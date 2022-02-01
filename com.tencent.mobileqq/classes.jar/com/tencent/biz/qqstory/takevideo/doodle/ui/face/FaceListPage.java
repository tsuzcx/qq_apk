package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import ykq;
import ykv;
import yry;
import yuq;
import yur;
import yut;
import yuu;
import yux;
import yva;
import yvd;
import yvh;

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
  private yuq jdField_a_of_type_Yuq;
  private yur jdField_a_of_type_Yur;
  private yut jdField_a_of_type_Yut;
  private yva jdField_a_of_type_Yva;
  private yvd jdField_a_of_type_Yvd;
  private yvh jdField_a_of_type_Yvh;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, yut paramyut, yuq paramyuq)
  {
    super(paramContext);
    this.jdField_a_of_type_Yuq = paramyuq;
    this.jdField_a_of_type_Yut = paramyut;
    d();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    ykq.b("FaceListPage", "FacePackage is LocationFacePackage");
    yuu localyuu = (yuu)this.jdField_a_of_type_Yur;
    if (!localyuu.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Yva.notifyDataSetChanged();
      return;
    }
    if (localyuu.jdField_a_of_type_Boolean)
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
  
  private void b(yur paramyur)
  {
    if ((paramyur instanceof yux))
    {
      if (this.jdField_a_of_type_Yvh == null) {
        this.jdField_a_of_type_Yvh = new yvh(super.getContext());
      }
      this.jdField_a_of_type_Yva = this.jdField_a_of_type_Yvh;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Yva != null)
      {
        this.jdField_a_of_type_Yva.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Yva.a(this.jdField_a_of_type_Yut);
        this.jdField_a_of_type_Yva.a(paramyur);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Yva);
      }
      return;
      if ((paramyur instanceof yuu))
      {
        if (this.jdField_a_of_type_Yvd == null) {
          this.jdField_a_of_type_Yvd = new yvd(super.getContext());
        }
        this.jdField_a_of_type_Yva = this.jdField_a_of_type_Yvd;
      }
      else
      {
        ykq.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    ykq.b("FaceListPage", "FacePackage is NormalFacePackage");
    yux localyux = (yux)this.jdField_a_of_type_Yur;
    if (!localyux.jdField_a_of_type_JavaUtilList.isEmpty()) {
      ykq.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localyux.f))
        {
          ykq.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localyux.a();
        }
      }
      if (bool2)
      {
        ykq.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
        postDelayed(new FaceListPage.2(this), 50L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131378495);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_Yur.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378495, this.jdField_a_of_type_Yur.d);
        yry.a().a(super.getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Yur.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localyux.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localyux.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localyux.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localyux.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localyux.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846498);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = AIOUtils.dp2px(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561665, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366382));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366383));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131373219));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131366369));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131366363));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131370499));
    this.c = ((LinearLayout)super.findViewById(2131370505));
    this.d = ((LinearLayout)super.findViewById(2131370495));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365827));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Yur == null) {
      ykq.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Yur.a())) {
            break;
          }
          localObject = (yuu)this.jdField_a_of_type_Yur;
        } while ((!((yuu)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((yuu)localObject).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
        if (NetworkUtil.isNetworkAvailable(super.getContext())) {
          ykv.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          ykv.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Yur.a()));
      localObject = (yux)this.jdField_a_of_type_Yur;
    } while ((!NetworkUtil.isWifiEnabled(getContext())) || (this.jdField_a_of_type_Yuq == null) || (((yux)localObject).jdField_a_of_type_Boolean) || (!((yux)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    ykq.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Yuq.a(((yux)localObject).jdField_a_of_type_JavaLangString);
    ykv.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(yur paramyur)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, paramyur));
    }
    do
    {
      return;
      if (paramyur == null) {
        break;
      }
      ykq.b("FaceListPage", "onChange,FacePkgInfo:" + paramyur.toString());
      if ((this.jdField_a_of_type_Yur == null) || (!this.jdField_a_of_type_Yur.a().equals(paramyur.a()))) {
        b(paramyur);
      }
      this.jdField_a_of_type_Yur = paramyur;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Yur.a()))
      {
        c();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_Yur.a()));
    b();
    return;
    ykq.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Yur = null;
    this.jdField_a_of_type_Yva.a(null);
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
      if (this.jdField_a_of_type_Yuq != null)
      {
        if (((yux)this.jdField_a_of_type_Yur).jdField_a_of_type_Boolean) {
          break label83;
        }
        ykq.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Yur.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Yuq.a(this.jdField_a_of_type_Yur.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      this.jdField_a_of_type_Yuq.b(this.jdField_a_of_type_Yur.jdField_a_of_type_JavaLangString);
      continue;
      if ((paramView == this.c) && (this.jdField_a_of_type_Yuq != null))
      {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.jdField_a_of_type_Yuq.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */