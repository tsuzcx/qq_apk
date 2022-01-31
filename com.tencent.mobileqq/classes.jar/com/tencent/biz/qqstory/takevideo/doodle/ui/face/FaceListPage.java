package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import aciy;
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
import badq;
import java.util.List;
import urk;
import urp;
import uyx;
import vbw;
import vbx;
import vbz;
import vca;
import vcd;
import vcg;
import vcj;
import vcn;

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
  private vbw jdField_a_of_type_Vbw;
  private vbx jdField_a_of_type_Vbx;
  private vbz jdField_a_of_type_Vbz;
  private vcg jdField_a_of_type_Vcg;
  private vcj jdField_a_of_type_Vcj;
  private vcn jdField_a_of_type_Vcn;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, vbz paramvbz, vbw paramvbw)
  {
    super(paramContext);
    this.jdField_a_of_type_Vbw = paramvbw;
    this.jdField_a_of_type_Vbz = paramvbz;
    d();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    urk.b("FaceListPage", "FacePackage is LocationFacePackage");
    vca localvca = (vca)this.jdField_a_of_type_Vbx;
    if (!localvca.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Vcg.notifyDataSetChanged();
      return;
    }
    if (localvca.jdField_a_of_type_Boolean)
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
  
  private void b(vbx paramvbx)
  {
    if ((paramvbx instanceof vcd))
    {
      if (this.jdField_a_of_type_Vcn == null) {
        this.jdField_a_of_type_Vcn = new vcn(super.getContext());
      }
      this.jdField_a_of_type_Vcg = this.jdField_a_of_type_Vcn;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Vcg != null)
      {
        this.jdField_a_of_type_Vcg.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Vcg.a(this.jdField_a_of_type_Vbz);
        this.jdField_a_of_type_Vcg.a(paramvbx);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Vcg);
      }
      return;
      if ((paramvbx instanceof vca))
      {
        if (this.jdField_a_of_type_Vcj == null) {
          this.jdField_a_of_type_Vcj = new vcj(super.getContext());
        }
        this.jdField_a_of_type_Vcg = this.jdField_a_of_type_Vcj;
      }
      else
      {
        urk.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    urk.b("FaceListPage", "FacePackage is NormalFacePackage");
    vcd localvcd = (vcd)this.jdField_a_of_type_Vbx;
    if (!localvcd.jdField_a_of_type_JavaUtilList.isEmpty()) {
      urk.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localvcd.f))
        {
          urk.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localvcd.a();
        }
      }
      if (bool2)
      {
        urk.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
        postDelayed(new FaceListPage.2(this), 50L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131311070);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_Vbx.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131311070, this.jdField_a_of_type_Vbx.d);
        uyx.a().a(super.getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Vbx.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localvcd.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localvcd.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localvcd.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localvcd.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localvcd.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845396);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = aciy.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131495644, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131300264));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300265));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131306298));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131300252));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131300245));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131303858));
    this.c = ((LinearLayout)super.findViewById(2131303863));
    this.d = ((LinearLayout)super.findViewById(2131303855));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299769));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Vbx == null) {
      urk.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Vbx.a())) {
            break;
          }
          localObject = (vca)this.jdField_a_of_type_Vbx;
        } while ((!((vca)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((vca)localObject).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
        if (badq.g(super.getContext())) {
          urp.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          urp.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Vbx.a()));
      localObject = (vcd)this.jdField_a_of_type_Vbx;
    } while ((!badq.a(getContext())) || (this.jdField_a_of_type_Vbw == null) || (((vcd)localObject).jdField_a_of_type_Boolean) || (!((vcd)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    urk.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Vbw.a(((vcd)localObject).jdField_a_of_type_JavaLangString);
    urp.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(vbx paramvbx)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, paramvbx));
    }
    do
    {
      return;
      if (paramvbx == null) {
        break;
      }
      urk.b("FaceListPage", "onChange,FacePkgInfo:" + paramvbx.toString());
      if ((this.jdField_a_of_type_Vbx == null) || (!this.jdField_a_of_type_Vbx.a().equals(paramvbx.a()))) {
        b(paramvbx);
      }
      this.jdField_a_of_type_Vbx = paramvbx;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Vbx.a()))
      {
        c();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_Vbx.a()));
    b();
    return;
    urk.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Vbx = null;
    this.jdField_a_of_type_Vcg.a(null);
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
      if (this.jdField_a_of_type_Vbw != null)
      {
        if (((vcd)this.jdField_a_of_type_Vbx).jdField_a_of_type_Boolean) {
          break label76;
        }
        urk.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Vbx.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Vbw.a(this.jdField_a_of_type_Vbx.jdField_a_of_type_JavaLangString);
      }
    }
    label76:
    while ((paramView != this.c) || (this.jdField_a_of_type_Vbw == null))
    {
      return;
      this.jdField_a_of_type_Vbw.b(this.jdField_a_of_type_Vbx.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_Vbw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */