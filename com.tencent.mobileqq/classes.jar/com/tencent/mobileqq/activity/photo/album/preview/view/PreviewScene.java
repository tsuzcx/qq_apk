package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCommonUtil;
import com.tencent.mobileqq.activity.photo.album.preview.AlbumItemDecoration;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView;
import java.util.ArrayList;

public class PreviewScene
  extends MainBrowserScene
  implements CompoundButton.OnCheckedChangeListener
{
  public PeakFragmentActivity a;
  public ISceneCallback b;
  public RelativeLayout c;
  public View d;
  public View e;
  public ViewGroup f;
  public TextView g;
  public CheckBox h;
  public TextView i;
  public CheckBox j;
  public TextView k;
  public Button l;
  public NumberCheckBox m;
  public View n;
  public TextView o;
  public TextView p;
  public int q;
  public int r;
  float s = 13.0F;
  float t = 9.0F;
  private PreviewPresenter<? extends OtherCommonData> u;
  
  public PreviewScene(PeakFragmentActivity paramPeakFragmentActivity, PreviewPresenter paramPreviewPresenter)
  {
    super(paramPeakFragmentActivity, paramPreviewPresenter);
    this.a = paramPeakFragmentActivity;
    this.u = paramPreviewPresenter;
  }
  
  public View a()
  {
    this.c = new RelativeLayout(this.a);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setBackgroundColor(this.a.getResources().getColor(2131168376));
    this.d = this.b.v();
    localObject = this.d;
    if (localObject != null)
    {
      ((View)localObject).setId(View.generateViewId());
      localObject = this.b.w();
      if (localObject != null) {
        this.c.addView(this.d, (ViewGroup.LayoutParams)localObject);
      } else {
        this.c.addView(this.d);
      }
    }
    this.e = this.b.x();
    localObject = this.e;
    if (localObject != null)
    {
      ((View)localObject).setId(View.generateViewId());
      localObject = this.b.y();
      if (localObject != null) {
        this.c.addView(this.e, (ViewGroup.LayoutParams)localObject);
      } else {
        this.c.addView(this.d);
      }
    }
    return this.c;
  }
  
  public void a(int paramInt)
  {
    String str = getItem(paramInt).baseData.filePath;
    if (this.u.c.selectedIndex.contains(Integer.valueOf(paramInt)))
    {
      if (str != null) {
        a(str);
      } else {
        this.m.setChecked(false);
      }
    }
    else {
      this.m.setChecked(false);
    }
    this.b.b();
    if (!this.u.d.B) {
      if (this.u.d.y.size() > 1)
      {
        TextView localTextView = this.p;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt + 1);
        localStringBuilder.append(" / ");
        localStringBuilder.append(this.u.d.y.size());
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        this.p.setText(this.a.getResources().getString(2131892721));
      }
    }
    if ((this.u.b(str) == 1) && (!this.u.d.x)) {
      k();
    }
  }
  
  public void a(View paramView)
  {
    this.a.getResources();
    int i1 = m();
    if (this.u.c.selectedIndex.contains(Integer.valueOf(i1)))
    {
      this.m.setChecked(false);
      int i2 = this.u.c.selectedIndex.indexOf(Integer.valueOf(i1));
      if (i2 >= 0)
      {
        this.u.c.selectedIndex.remove(i2);
        if (i1 != -1) {
          this.u.c.selectedPhotoList.remove(this.u.d.y.get(i1));
        }
      }
    }
    else
    {
      if (this.u.c.selectedPhotoList.size() >= this.u.c.maxSelectNum)
      {
        long l1 = System.currentTimeMillis();
        if (l1 - this.u.d.C >= 700L)
        {
          QQToast.makeText(this.a, i(), 1000).show();
          this.u.d.C = l1;
        }
        this.m.setChecked(false);
        return;
      }
      if (i1 != -1)
      {
        paramView = (String)this.u.d.y.get(i1);
        this.u.c.selectedPhotoList.add(paramView);
        this.u.c.selectedIndex.add(Integer.valueOf(i1));
        a(paramView);
      }
    }
    this.b.b();
  }
  
  public void a(ISceneCallback paramISceneCallback)
  {
    this.b = paramISceneCallback;
  }
  
  public void a(String paramString)
  {
    a(paramString, -1);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt >= 0)
    {
      this.m.setCheckedNumber(paramInt);
      return;
    }
    paramInt = this.u.c.selectedPhotoList.indexOf(paramString) + 1;
    if (paramInt <= 0)
    {
      this.m.setChecked(false);
      return;
    }
    if (paramInt >= 100) {
      this.m.setTextSize(this.t);
    } else {
      this.m.setTextSize(this.s);
    }
    this.m.setCheckedNumber(paramInt);
  }
  
  public View b()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.a.getSystemService("layout_inflater");
    View localView = null;
    if (localLayoutInflater != null) {
      localView = localLayoutInflater.inflate(2131627646, null);
    }
    return localView;
  }
  
  public RelativeLayout.LayoutParams c()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null)) {
      return new RelativeLayout.LayoutParams(this.d.getLayoutParams());
    }
    localObject = new RelativeLayout.LayoutParams(-1, (int)this.a.getResources().getDimension(2131299920));
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    return localObject;
  }
  
  public View d()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.a.getSystemService("layout_inflater");
    View localView = null;
    if (localLayoutInflater != null) {
      localView = localLayoutInflater.inflate(2131627645, null);
    }
    return localView;
  }
  
  public RelativeLayout.LayoutParams e()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null)) {
      return new RelativeLayout.LayoutParams(this.e.getLayoutParams());
    }
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    return localObject;
  }
  
  public void f()
  {
    if (this.u.d.x) {
      this.c.setVisibility(0);
    } else {
      this.c.setVisibility(4);
    }
    if (this.u.d.B)
    {
      localObject = this.p;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    Object localObject = this.n;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new PreviewScene.1(this));
    }
    localObject = this.o;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new PreviewScene.2(this));
    }
    this.b.b();
    if (this.u.c.isSingleMode)
    {
      localObject = this.m;
      if (localObject != null) {
        ((NumberCheckBox)localObject).setVisibility(8);
      }
      localObject = this.n;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  public void g()
  {
    Intent localIntent = this.a.getIntent();
    if ("FROM_PHOTO_LIST".equals(this.u.d.A))
    {
      localIntent.setClass(this.a, this.b.q());
      if (this.u.c.isSingleMode)
      {
        localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      }
      else
      {
        localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.u.c.selectedPhotoList);
        localIntent.putExtra("PhotoConst.editPathMap", this.u.d.z);
      }
      this.a.startActivity(localIntent);
    }
    if (localIntent.getBooleanExtra("keep_selected_status_after_finish", false))
    {
      localIntent = new Intent();
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.u.c.selectedPhotoList);
      localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.u.c.selectedIndex);
      localIntent.putExtra("PhotoConst.editPathMap", this.u.d.z);
      this.a.setResult(-1, localIntent);
    }
    this.a.finish();
  }
  
  public void h()
  {
    if (this.l != null)
    {
      Object localObject = this.a.getResources();
      if (this.u.c.customSendBtnText != null) {
        localObject = this.u.c.customSendBtnText;
      } else {
        localObject = ((Resources)localObject).getString(2131892542);
      }
      int i1;
      if ((this.u.c.selectedPhotoList != null) && (this.u.c.selectedPhotoList.size() > 0)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        this.l.setEnabled(true);
        if (this.u.c.isSingleMode)
        {
          this.l.setText((CharSequence)localObject);
        }
        else
        {
          Button localButton = this.l;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("(");
          localStringBuilder.append(this.u.c.selectedPhotoList.size());
          localStringBuilder.append(")");
          localButton.setText(localStringBuilder.toString());
        }
      }
      else
      {
        this.l.setText((CharSequence)localObject);
      }
    }
    if (this.m != null)
    {
      if ((!this.u.c.selectedIndex.contains(Integer.valueOf(m()))) && (this.u.c.selectedPhotoList.size() >= this.u.c.maxSelectNum))
      {
        this.m.setActivated(true);
        return;
      }
      this.m.setActivated(false);
    }
  }
  
  public String i()
  {
    return this.a.getResources().getString(2131892559, new Object[] { Integer.valueOf(this.u.c.maxSelectNum) });
  }
  
  public void initView()
  {
    super.initView();
    a();
    Object localObject = this.e;
    if (localObject != null)
    {
      this.f = ((ViewGroup)((View)localObject).findViewById(2131429635));
      this.g = ((TextView)this.e.findViewById(2131437877));
      this.h = ((CheckBox)this.e.findViewById(2131433324));
      this.i = ((TextView)this.e.findViewById(2131433325));
      this.j = ((CheckBox)this.e.findViewById(2131442912));
      this.k = ((TextView)this.e.findViewById(2131442918));
      this.l = ((Button)this.e.findViewById(2131445580));
    }
    localObject = this.d;
    if (localObject != null)
    {
      this.m = ((NumberCheckBox)((View)localObject).findViewById(2131445553));
      this.n = this.d.findViewById(2131445529);
      this.p = ((TextView)this.d.findViewById(2131447463));
      this.o = ((TextView)this.d.findViewById(2131429224));
    }
    localObject = this.h;
    if (localObject != null) {
      ((CheckBox)localObject).setVisibility(8);
    }
    localObject = this.i;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.j;
    if (localObject != null) {
      ((CheckBox)localObject).setVisibility(8);
    }
    localObject = this.k;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.g;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    getContentView().addView(this.c);
    if (this.recyclerView != null) {
      this.recyclerView.addItemDecoration(new AlbumItemDecoration(QAlbumCommonUtil.dp2px(2.5F, this.mContext.getResources())));
    }
    this.b.a();
  }
  
  public void j()
  {
    this.u.d.x = false;
    this.c.setVisibility(4);
  }
  
  public void k()
  {
    this.u.d.x = true;
    this.c.setVisibility(0);
  }
  
  public ArrayList<String> l()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.u.c.selectedPhotoList.isEmpty())
    {
      int i1 = m();
      if ((i1 < this.u.d.y.size()) && (i1 != -1))
      {
        localArrayList.add(this.u.d.y.get(i1));
        return localArrayList;
      }
    }
    else
    {
      localArrayList.addAll(this.u.c.selectedPhotoList);
    }
    return localArrayList;
  }
  
  public int m()
  {
    return this.u.getCurrentPosition();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i1 = paramCompoundButton.getId();
    if (i1 == 2131442912) {
      this.b.a(paramCompoundButton, paramBoolean);
    } else if (i1 == 2131433324) {
      this.b.a(paramBoolean);
    }
    if ((!this.j.isChecked()) && (!this.h.isChecked()))
    {
      this.k.setTextColor(-1);
      this.i.setTextColor(-1);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClickDragView()
  {
    super.onClickDragView();
    this.b.onClickDragView();
  }
  
  public void onContentMove(float paramFloat)
  {
    super.onContentMove(paramFloat);
    this.b.onContentMove(paramFloat);
  }
  
  public void onGestureFinish()
  {
    this.b.onGestureFinish();
  }
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    this.b.a(paramInt);
  }
  
  public void onResetPosition()
  {
    super.onResetPosition();
    this.b.onResetPosition();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene
 * JD-Core Version:    0.7.0.1
 */