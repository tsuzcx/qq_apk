package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import actn;
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
import bbev;
import java.util.List;
import veg;
import vel;
import vlt;
import vos;
import vot;
import vov;
import vow;
import voz;
import vpc;
import vpf;
import vpj;

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
  private vos jdField_a_of_type_Vos;
  private vot jdField_a_of_type_Vot;
  private vov jdField_a_of_type_Vov;
  private vpc jdField_a_of_type_Vpc;
  private vpf jdField_a_of_type_Vpf;
  private vpj jdField_a_of_type_Vpj;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, vov paramvov, vos paramvos)
  {
    super(paramContext);
    this.jdField_a_of_type_Vos = paramvos;
    this.jdField_a_of_type_Vov = paramvov;
    d();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    veg.b("FaceListPage", "FacePackage is LocationFacePackage");
    vow localvow = (vow)this.jdField_a_of_type_Vot;
    if (!localvow.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Vpc.notifyDataSetChanged();
      return;
    }
    if (localvow.jdField_a_of_type_Boolean)
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
  
  private void b(vot paramvot)
  {
    if ((paramvot instanceof voz))
    {
      if (this.jdField_a_of_type_Vpj == null) {
        this.jdField_a_of_type_Vpj = new vpj(super.getContext());
      }
      this.jdField_a_of_type_Vpc = this.jdField_a_of_type_Vpj;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Vpc != null)
      {
        this.jdField_a_of_type_Vpc.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Vpc.a(this.jdField_a_of_type_Vov);
        this.jdField_a_of_type_Vpc.a(paramvot);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Vpc);
      }
      return;
      if ((paramvot instanceof vow))
      {
        if (this.jdField_a_of_type_Vpf == null) {
          this.jdField_a_of_type_Vpf = new vpf(super.getContext());
        }
        this.jdField_a_of_type_Vpc = this.jdField_a_of_type_Vpf;
      }
      else
      {
        veg.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    veg.b("FaceListPage", "FacePackage is NormalFacePackage");
    voz localvoz = (voz)this.jdField_a_of_type_Vot;
    if (!localvoz.jdField_a_of_type_JavaUtilList.isEmpty()) {
      veg.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localvoz.f))
        {
          veg.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localvoz.a();
        }
      }
      if (bool2)
      {
        veg.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
        postDelayed(new FaceListPage.2(this), 50L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131376880);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_Vot.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131376880, this.jdField_a_of_type_Vot.d);
        vlt.a().a(super.getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Vot.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localvoz.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localvoz.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localvoz.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localvoz.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localvoz.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845580);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = actn.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561235, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365863));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365864));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131371995));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131365850));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131365843));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131369533));
    this.c = ((LinearLayout)super.findViewById(2131369538));
    this.d = ((LinearLayout)super.findViewById(2131369530));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365336));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Vot == null) {
      veg.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Vot.a())) {
            break;
          }
          localObject = (vow)this.jdField_a_of_type_Vot;
        } while ((!((vow)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((vow)localObject).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
        if (bbev.g(super.getContext())) {
          vel.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          vel.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Vot.a()));
      localObject = (voz)this.jdField_a_of_type_Vot;
    } while ((!bbev.a(getContext())) || (this.jdField_a_of_type_Vos == null) || (((voz)localObject).jdField_a_of_type_Boolean) || (!((voz)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    veg.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Vos.a(((voz)localObject).jdField_a_of_type_JavaLangString);
    vel.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(vot paramvot)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, paramvot));
    }
    do
    {
      return;
      if (paramvot == null) {
        break;
      }
      veg.b("FaceListPage", "onChange,FacePkgInfo:" + paramvot.toString());
      if ((this.jdField_a_of_type_Vot == null) || (!this.jdField_a_of_type_Vot.a().equals(paramvot.a()))) {
        b(paramvot);
      }
      this.jdField_a_of_type_Vot = paramvot;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Vot.a()))
      {
        c();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_Vot.a()));
    b();
    return;
    veg.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Vot = null;
    this.jdField_a_of_type_Vpc.a(null);
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
      if (this.jdField_a_of_type_Vos != null)
      {
        if (((voz)this.jdField_a_of_type_Vot).jdField_a_of_type_Boolean) {
          break label76;
        }
        veg.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Vot.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Vos.a(this.jdField_a_of_type_Vot.jdField_a_of_type_JavaLangString);
      }
    }
    label76:
    while ((paramView != this.c) || (this.jdField_a_of_type_Vos == null))
    {
      return;
      this.jdField_a_of_type_Vos.b(this.jdField_a_of_type_Vot.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_Vos.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */