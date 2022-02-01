package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;

public class EditTextEffectView
  extends RecyclerView
  implements Handler.Callback
{
  public static final int a;
  public static final int b;
  public static final int c;
  EditTextEffectView.EditTextAdapter d = null;
  LinearLayoutManager e;
  OnHolderItemClickListener f;
  public Handler g = null;
  public Vector<DynamicTextConfigManager.DynamicTextConfigBean> h = new Vector();
  int i = -1;
  public boolean j = false;
  CaptureConfigUpdateObserver k = new EditTextEffectView.1(this);
  private int l;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = AIOUtils.b(9.0F, localResources);
    a = AIOUtils.b(13.0F, localResources);
    c = AIOUtils.b(3.0F, localResources);
  }
  
  public EditTextEffectView(Context paramContext, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramContext);
    this.f = paramOnHolderItemClickListener;
    setClipToPadding(false);
    b();
    a();
    setClipChildren(false);
  }
  
  private List<DynamicTextConfigManager.DynamicTextConfigBean> a(List<DynamicTextConfigManager.DynamicTextConfigBean> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (((DynamicTextConfigManager.DynamicTextConfigBean)localIterator.next()).text_id >= 34) {
        localIterator.remove();
      }
    }
    while (paramList.size() > 34) {
      paramList.remove(paramList.size() - 1);
    }
    return paramList;
  }
  
  public int a(int paramInt)
  {
    EditTextEffectView.EditTextAdapter localEditTextAdapter = this.d;
    if ((localEditTextAdapter != null) && (localEditTextAdapter.a != null))
    {
      int n = this.d.a.size();
      int m = 0;
      while (m < n)
      {
        if (((DynamicTextConfigManager.DynamicTextConfigBean)this.d.a.get(m)).text_id == paramInt) {
          return m;
        }
        m += 1;
      }
    }
    return -1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextEffectView", 2, "loadData");
    }
    Object localObject = (DynamicTextConfigManager)QIMManager.a(7);
    if (!((DynamicTextConfigManager)localObject).e()) {
      ((DynamicTextConfigManager)localObject).b();
    }
    this.h.clear();
    localObject = ((DynamicTextConfigManager)localObject).a();
    this.h.addAll(a((List)localObject));
    this.d.a(this.h);
    this.d.notifyDataSetChanged();
  }
  
  @TargetApi(9)
  public void b()
  {
    setOverScrollMode(2);
    this.e = new LinearLayoutManager(getContext());
    this.e.setOrientation(0);
    setLayoutManager(this.e);
    this.d = new EditTextEffectView.EditTextAdapter(this, this.f);
    setAdapter(this.d);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    int n;
    int m;
    if ((this.d.a != null) && (paramInt < this.d.a.size()))
    {
      this.i = ((DynamicTextConfigManager.DynamicTextConfigBean)this.d.a.get(paramInt)).text_id;
      n = this.e.getChildCount();
      m = 0;
    }
    while (m < n)
    {
      Object localObject = (EditTextEffectView.EditTextHolder)getChildViewHolder(this.e.getChildAt(m));
      if (((EditTextEffectView.EditTextHolder)localObject).j != paramInt)
      {
        ((EditTextEffectView.EditTextHolder)localObject).b(false);
      }
      else
      {
        ((EditTextEffectView.EditTextHolder)localObject).b(true);
        StoryReportor.a("video_edit_new", "text_element", this.l, 0, new String[] { "0", String.valueOf(this.i) });
      }
      m += 1;
      continue;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select position = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" no item");
      QLog.e("EditTextEffectView", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean c(int paramInt)
  {
    if (this.d.a == null) {
      return null;
    }
    return (DynamicTextConfigManager.DynamicTextConfigBean)this.d.a.get(paramInt);
  }
  
  public int getSize()
  {
    if (this.d.a == null) {
      return 0;
    }
    return this.d.a.size();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      a();
    }
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
    this.k = new CaptureConfigUpdateObserver();
    localAppRuntime.registObserver(this.k);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    BaseApplicationImpl.getApplication().waitAppRuntime(null).unRegistObserver(this.k);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditTextEffectView", 2, "exittext panel visible");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("EditTextEffectView", 2, "exittext panel gone");
    }
  }
  
  public void setEditPhoto(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setOpIn(int paramInt)
  {
    this.l = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextEffectView
 * JD-Core Version:    0.7.0.1
 */