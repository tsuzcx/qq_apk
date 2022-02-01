package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import afur;
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
import bgnt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import yqp;
import yqu;
import yyc;
import zbb;
import zbc;
import zbe;
import zbf;
import zbi;
import zbl;
import zbo;
import zbs;

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
  private zbb jdField_a_of_type_Zbb;
  private zbc jdField_a_of_type_Zbc;
  private zbe jdField_a_of_type_Zbe;
  private zbl jdField_a_of_type_Zbl;
  private zbo jdField_a_of_type_Zbo;
  private zbs jdField_a_of_type_Zbs;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, zbe paramzbe, zbb paramzbb)
  {
    super(paramContext);
    this.jdField_a_of_type_Zbb = paramzbb;
    this.jdField_a_of_type_Zbe = paramzbe;
    d();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    yqp.b("FaceListPage", "FacePackage is LocationFacePackage");
    zbf localzbf = (zbf)this.jdField_a_of_type_Zbc;
    if (!localzbf.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Zbl.notifyDataSetChanged();
      return;
    }
    if (localzbf.jdField_a_of_type_Boolean)
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
  
  private void b(zbc paramzbc)
  {
    if ((paramzbc instanceof zbi))
    {
      if (this.jdField_a_of_type_Zbs == null) {
        this.jdField_a_of_type_Zbs = new zbs(super.getContext());
      }
      this.jdField_a_of_type_Zbl = this.jdField_a_of_type_Zbs;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Zbl != null)
      {
        this.jdField_a_of_type_Zbl.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Zbl.a(this.jdField_a_of_type_Zbe);
        this.jdField_a_of_type_Zbl.a(paramzbc);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Zbl);
      }
      return;
      if ((paramzbc instanceof zbf))
      {
        if (this.jdField_a_of_type_Zbo == null) {
          this.jdField_a_of_type_Zbo = new zbo(super.getContext());
        }
        this.jdField_a_of_type_Zbl = this.jdField_a_of_type_Zbo;
      }
      else
      {
        yqp.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    yqp.b("FaceListPage", "FacePackage is NormalFacePackage");
    zbi localzbi = (zbi)this.jdField_a_of_type_Zbc;
    if (!localzbi.jdField_a_of_type_JavaUtilList.isEmpty()) {
      yqp.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localzbi.f))
        {
          yqp.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localzbi.a();
        }
      }
      if (bool2)
      {
        yqp.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
        postDelayed(new FaceListPage.2(this), 50L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131378283);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_Zbc.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378283, this.jdField_a_of_type_Zbc.d);
        yyc.a().a(super.getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Zbc.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localzbi.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localzbi.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localzbi.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localzbi.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localzbi.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846477);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = afur.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561678, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366202));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366203));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131372926));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131366189));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131366183));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131370250));
    this.c = ((LinearLayout)super.findViewById(2131370255));
    this.d = ((LinearLayout)super.findViewById(2131370247));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365657));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Zbc == null) {
      yqp.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Zbc.a())) {
            break;
          }
          localObject = (zbf)this.jdField_a_of_type_Zbc;
        } while ((!((zbf)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((zbf)localObject).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
        if (bgnt.g(super.getContext())) {
          yqu.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          yqu.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Zbc.a()));
      localObject = (zbi)this.jdField_a_of_type_Zbc;
    } while ((!bgnt.a(getContext())) || (this.jdField_a_of_type_Zbb == null) || (((zbi)localObject).jdField_a_of_type_Boolean) || (!((zbi)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    yqp.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Zbb.a(((zbi)localObject).jdField_a_of_type_JavaLangString);
    yqu.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(zbc paramzbc)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, paramzbc));
    }
    do
    {
      return;
      if (paramzbc == null) {
        break;
      }
      yqp.b("FaceListPage", "onChange,FacePkgInfo:" + paramzbc.toString());
      if ((this.jdField_a_of_type_Zbc == null) || (!this.jdField_a_of_type_Zbc.a().equals(paramzbc.a()))) {
        b(paramzbc);
      }
      this.jdField_a_of_type_Zbc = paramzbc;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Zbc.a()))
      {
        c();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_Zbc.a()));
    b();
    return;
    yqp.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Zbc = null;
    this.jdField_a_of_type_Zbl.a(null);
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
      if (this.jdField_a_of_type_Zbb != null)
      {
        if (((zbi)this.jdField_a_of_type_Zbc).jdField_a_of_type_Boolean) {
          break label83;
        }
        yqp.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Zbc.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Zbb.a(this.jdField_a_of_type_Zbc.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      this.jdField_a_of_type_Zbb.b(this.jdField_a_of_type_Zbc.jdField_a_of_type_JavaLangString);
      continue;
      if ((paramView == this.c) && (this.jdField_a_of_type_Zbb != null))
      {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.jdField_a_of_type_Zbb.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */