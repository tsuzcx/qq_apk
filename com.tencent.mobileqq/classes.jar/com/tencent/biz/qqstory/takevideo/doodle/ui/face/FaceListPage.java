package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import agej;
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
import bhnv;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import yuk;
import yup;
import zbx;
import zew;
import zex;
import zez;
import zfa;
import zfd;
import zfg;
import zfj;
import zfn;

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
  private zew jdField_a_of_type_Zew;
  private zex jdField_a_of_type_Zex;
  private zez jdField_a_of_type_Zez;
  private zfg jdField_a_of_type_Zfg;
  private zfj jdField_a_of_type_Zfj;
  private zfn jdField_a_of_type_Zfn;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, zez paramzez, zew paramzew)
  {
    super(paramContext);
    this.jdField_a_of_type_Zew = paramzew;
    this.jdField_a_of_type_Zez = paramzez;
    d();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    yuk.b("FaceListPage", "FacePackage is LocationFacePackage");
    zfa localzfa = (zfa)this.jdField_a_of_type_Zex;
    if (!localzfa.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Zfg.notifyDataSetChanged();
      return;
    }
    if (localzfa.jdField_a_of_type_Boolean)
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
  
  private void b(zex paramzex)
  {
    if ((paramzex instanceof zfd))
    {
      if (this.jdField_a_of_type_Zfn == null) {
        this.jdField_a_of_type_Zfn = new zfn(super.getContext());
      }
      this.jdField_a_of_type_Zfg = this.jdField_a_of_type_Zfn;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Zfg != null)
      {
        this.jdField_a_of_type_Zfg.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Zfg.a(this.jdField_a_of_type_Zez);
        this.jdField_a_of_type_Zfg.a(paramzex);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Zfg);
      }
      return;
      if ((paramzex instanceof zfa))
      {
        if (this.jdField_a_of_type_Zfj == null) {
          this.jdField_a_of_type_Zfj = new zfj(super.getContext());
        }
        this.jdField_a_of_type_Zfg = this.jdField_a_of_type_Zfj;
      }
      else
      {
        yuk.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    yuk.b("FaceListPage", "FacePackage is NormalFacePackage");
    zfd localzfd = (zfd)this.jdField_a_of_type_Zex;
    if (!localzfd.jdField_a_of_type_JavaUtilList.isEmpty()) {
      yuk.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localzfd.f))
        {
          yuk.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localzfd.a();
        }
      }
      if (bool2)
      {
        yuk.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
        postDelayed(new FaceListPage.2(this), 50L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131378440);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_Zex.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378440, this.jdField_a_of_type_Zex.d);
        zbx.a().a(super.getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Zex.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localzfd.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localzfd.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localzfd.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localzfd.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localzfd.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846494);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = agej.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561719, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366251));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366252));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131373039));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131366238));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131366232));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131370351));
    this.c = ((LinearLayout)super.findViewById(2131370356));
    this.d = ((LinearLayout)super.findViewById(2131370348));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365700));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Zex == null) {
      yuk.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Zex.a())) {
            break;
          }
          localObject = (zfa)this.jdField_a_of_type_Zex;
        } while ((!((zfa)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((zfa)localObject).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
        if (bhnv.g(super.getContext())) {
          yup.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          yup.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Zex.a()));
      localObject = (zfd)this.jdField_a_of_type_Zex;
    } while ((!bhnv.a(getContext())) || (this.jdField_a_of_type_Zew == null) || (((zfd)localObject).jdField_a_of_type_Boolean) || (!((zfd)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    yuk.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Zew.a(((zfd)localObject).jdField_a_of_type_JavaLangString);
    yup.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(zex paramzex)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, paramzex));
    }
    do
    {
      return;
      if (paramzex == null) {
        break;
      }
      yuk.b("FaceListPage", "onChange,FacePkgInfo:" + paramzex.toString());
      if ((this.jdField_a_of_type_Zex == null) || (!this.jdField_a_of_type_Zex.a().equals(paramzex.a()))) {
        b(paramzex);
      }
      this.jdField_a_of_type_Zex = paramzex;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Zex.a()))
      {
        c();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_Zex.a()));
    b();
    return;
    yuk.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Zex = null;
    this.jdField_a_of_type_Zfg.a(null);
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
      if (this.jdField_a_of_type_Zew != null)
      {
        if (((zfd)this.jdField_a_of_type_Zex).jdField_a_of_type_Boolean) {
          break label83;
        }
        yuk.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Zex.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Zew.a(this.jdField_a_of_type_Zex.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      this.jdField_a_of_type_Zew.b(this.jdField_a_of_type_Zex.jdField_a_of_type_JavaLangString);
      continue;
      if ((paramView == this.c) && (this.jdField_a_of_type_Zew != null))
      {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.jdField_a_of_type_Zew.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */