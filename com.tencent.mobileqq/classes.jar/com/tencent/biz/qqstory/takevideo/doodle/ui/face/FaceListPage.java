package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import aepi;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdin;
import java.util.List;
import wxe;
import wxj;
import xer;
import xhq;
import xhr;
import xht;
import xhu;
import xhx;
import xia;
import xid;
import xih;

public class FaceListPage
  extends RelativeLayout
  implements View.OnClickListener
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private xhq jdField_a_of_type_Xhq;
  private xhr jdField_a_of_type_Xhr;
  private xht jdField_a_of_type_Xht;
  private xia jdField_a_of_type_Xia;
  private xid jdField_a_of_type_Xid;
  private xih jdField_a_of_type_Xih;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, xht paramxht, xhq paramxhq)
  {
    super(paramContext);
    this.jdField_a_of_type_Xhq = paramxhq;
    this.jdField_a_of_type_Xht = paramxht;
    d();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    wxe.b("FaceListPage", "FacePackage is LocationFacePackage");
    xhu localxhu = (xhu)this.jdField_a_of_type_Xhr;
    if (!localxhu.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Xia.notifyDataSetChanged();
      return;
    }
    if (localxhu.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.c.setVisibility(4);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(xhr paramxhr)
  {
    if ((paramxhr instanceof xhx))
    {
      if (this.jdField_a_of_type_Xih == null) {
        this.jdField_a_of_type_Xih = new xih(super.getContext());
      }
      this.jdField_a_of_type_Xia = this.jdField_a_of_type_Xih;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Xia != null)
      {
        this.jdField_a_of_type_Xia.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Xia.a(this.jdField_a_of_type_Xht);
        this.jdField_a_of_type_Xia.a(paramxhr);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Xia);
      }
      return;
      if ((paramxhr instanceof xhu))
      {
        if (this.jdField_a_of_type_Xid == null) {
          this.jdField_a_of_type_Xid = new xid(super.getContext());
        }
        this.jdField_a_of_type_Xia = this.jdField_a_of_type_Xid;
      }
      else
      {
        wxe.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    wxe.b("FaceListPage", "FacePackage is NormalFacePackage");
    xhx localxhx = (xhx)this.jdField_a_of_type_Xhr;
    if (!localxhx.jdField_a_of_type_JavaUtilList.isEmpty()) {
      wxe.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localxhx.f))
        {
          wxe.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localxhx.a();
        }
      }
      if (bool2)
      {
        wxe.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
        postDelayed(new FaceListPage.2(this), 50L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131377450);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_Xhr.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131377450, this.jdField_a_of_type_Xhr.d);
        xer.a().a(super.getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Xhr.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localxhx.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localxhx.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localxhx.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localxhx.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localxhx.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846038);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = aepi.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561442, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365951));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365952));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131372332));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131365938));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131365931));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131369813));
    this.c = ((LinearLayout)super.findViewById(2131369818));
    this.d = ((LinearLayout)super.findViewById(2131369810));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365422));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Xhr == null) {
      wxe.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Xhr.a())) {
            break;
          }
          localObject = (xhu)this.jdField_a_of_type_Xhr;
        } while ((!((xhu)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((xhu)localObject).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
        if (bdin.g(super.getContext())) {
          wxj.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          wxj.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Xhr.a()));
      localObject = (xhx)this.jdField_a_of_type_Xhr;
    } while ((!bdin.a(getContext())) || (this.jdField_a_of_type_Xhq == null) || (((xhx)localObject).jdField_a_of_type_Boolean) || (!((xhx)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    wxe.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Xhq.a(((xhx)localObject).jdField_a_of_type_JavaLangString);
    wxj.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(xhr paramxhr)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, paramxhr));
    }
    do
    {
      return;
      if (paramxhr == null) {
        break;
      }
      wxe.b("FaceListPage", "onChange,FacePkgInfo:" + paramxhr.toString());
      if ((this.jdField_a_of_type_Xhr == null) || (!this.jdField_a_of_type_Xhr.a().equals(paramxhr.a()))) {
        b(paramxhr);
      }
      this.jdField_a_of_type_Xhr = paramxhr;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Xhr.a()))
      {
        c();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_Xhr.a()));
    b();
    return;
    wxe.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Xhr = null;
    this.jdField_a_of_type_Xia.a(null);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetTextView) {
      if (this.jdField_a_of_type_Xhq != null)
      {
        if (((xhx)this.jdField_a_of_type_Xhr).jdField_a_of_type_Boolean) {
          break label76;
        }
        wxe.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Xhr.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Xhq.a(this.jdField_a_of_type_Xhr.jdField_a_of_type_JavaLangString);
      }
    }
    label76:
    while ((paramView != this.c) || (this.jdField_a_of_type_Xhq == null))
    {
      return;
      this.jdField_a_of_type_Xhq.b(this.jdField_a_of_type_Xhr.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_Xhq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */