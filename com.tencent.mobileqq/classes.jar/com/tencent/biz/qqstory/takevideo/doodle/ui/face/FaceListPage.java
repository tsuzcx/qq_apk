package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import actj;
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
import bbfj;
import java.util.List;
import ved;
import vei;
import vlq;
import vop;
import voq;
import vos;
import vot;
import vow;
import voz;
import vpc;
import vpg;

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
  private vop jdField_a_of_type_Vop;
  private voq jdField_a_of_type_Voq;
  private vos jdField_a_of_type_Vos;
  private voz jdField_a_of_type_Voz;
  private vpc jdField_a_of_type_Vpc;
  private vpg jdField_a_of_type_Vpg;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, vos paramvos, vop paramvop)
  {
    super(paramContext);
    this.jdField_a_of_type_Vop = paramvop;
    this.jdField_a_of_type_Vos = paramvos;
    d();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    ved.b("FaceListPage", "FacePackage is LocationFacePackage");
    vot localvot = (vot)this.jdField_a_of_type_Voq;
    if (!localvot.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Voz.notifyDataSetChanged();
      return;
    }
    if (localvot.jdField_a_of_type_Boolean)
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
  
  private void b(voq paramvoq)
  {
    if ((paramvoq instanceof vow))
    {
      if (this.jdField_a_of_type_Vpg == null) {
        this.jdField_a_of_type_Vpg = new vpg(super.getContext());
      }
      this.jdField_a_of_type_Voz = this.jdField_a_of_type_Vpg;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Voz != null)
      {
        this.jdField_a_of_type_Voz.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Voz.a(this.jdField_a_of_type_Vos);
        this.jdField_a_of_type_Voz.a(paramvoq);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Voz);
      }
      return;
      if ((paramvoq instanceof vot))
      {
        if (this.jdField_a_of_type_Vpc == null) {
          this.jdField_a_of_type_Vpc = new vpc(super.getContext());
        }
        this.jdField_a_of_type_Voz = this.jdField_a_of_type_Vpc;
      }
      else
      {
        ved.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    ved.b("FaceListPage", "FacePackage is NormalFacePackage");
    vow localvow = (vow)this.jdField_a_of_type_Voq;
    if (!localvow.jdField_a_of_type_JavaUtilList.isEmpty()) {
      ved.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localvow.f))
        {
          ved.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localvow.a();
        }
      }
      if (bool2)
      {
        ved.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
        postDelayed(new FaceListPage.2(this), 50L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131376882);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_Voq.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131376882, this.jdField_a_of_type_Voq.d);
        vlq.a().a(super.getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Voq.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localvow.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localvow.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localvow.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localvow.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localvow.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845586);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = actj.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561234, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365863));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365864));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131371995));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131365850));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131365843));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131369532));
    this.c = ((LinearLayout)super.findViewById(2131369537));
    this.d = ((LinearLayout)super.findViewById(2131369529));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365335));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Voq == null) {
      ved.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Voq.a())) {
            break;
          }
          localObject = (vot)this.jdField_a_of_type_Voq;
        } while ((!((vot)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((vot)localObject).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
        if (bbfj.g(super.getContext())) {
          vei.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          vei.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Voq.a()));
      localObject = (vow)this.jdField_a_of_type_Voq;
    } while ((!bbfj.a(getContext())) || (this.jdField_a_of_type_Vop == null) || (((vow)localObject).jdField_a_of_type_Boolean) || (!((vow)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    ved.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Vop.a(((vow)localObject).jdField_a_of_type_JavaLangString);
    vei.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(voq paramvoq)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, paramvoq));
    }
    do
    {
      return;
      if (paramvoq == null) {
        break;
      }
      ved.b("FaceListPage", "onChange,FacePkgInfo:" + paramvoq.toString());
      if ((this.jdField_a_of_type_Voq == null) || (!this.jdField_a_of_type_Voq.a().equals(paramvoq.a()))) {
        b(paramvoq);
      }
      this.jdField_a_of_type_Voq = paramvoq;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Voq.a()))
      {
        c();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_Voq.a()));
    b();
    return;
    ved.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Voq = null;
    this.jdField_a_of_type_Voz.a(null);
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
      if (this.jdField_a_of_type_Vop != null)
      {
        if (((vow)this.jdField_a_of_type_Voq).jdField_a_of_type_Boolean) {
          break label76;
        }
        ved.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Voq.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Vop.a(this.jdField_a_of_type_Voq.jdField_a_of_type_JavaLangString);
      }
    }
    label76:
    while ((paramView != this.c) || (this.jdField_a_of_type_Vop == null))
    {
      return;
      this.jdField_a_of_type_Vop.b(this.jdField_a_of_type_Voq.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_Vop.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */