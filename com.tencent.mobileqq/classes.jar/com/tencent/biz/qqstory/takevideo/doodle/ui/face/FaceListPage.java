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
import xvv;
import xwa;
import ydf;
import yfx;
import yfy;
import yga;
import ygb;
import yge;
import ygh;
import ygk;
import ygo;

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
  private yfx jdField_a_of_type_Yfx;
  private yfy jdField_a_of_type_Yfy;
  private yga jdField_a_of_type_Yga;
  private ygh jdField_a_of_type_Ygh;
  private ygk jdField_a_of_type_Ygk;
  private ygo jdField_a_of_type_Ygo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, yga paramyga, yfx paramyfx)
  {
    super(paramContext);
    this.jdField_a_of_type_Yfx = paramyfx;
    this.jdField_a_of_type_Yga = paramyga;
    d();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    xvv.b("FaceListPage", "FacePackage is LocationFacePackage");
    ygb localygb = (ygb)this.jdField_a_of_type_Yfy;
    if (!localygb.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Ygh.notifyDataSetChanged();
      return;
    }
    if (localygb.jdField_a_of_type_Boolean)
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
  
  private void b(yfy paramyfy)
  {
    if ((paramyfy instanceof yge))
    {
      if (this.jdField_a_of_type_Ygo == null) {
        this.jdField_a_of_type_Ygo = new ygo(super.getContext());
      }
      this.jdField_a_of_type_Ygh = this.jdField_a_of_type_Ygo;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ygh != null)
      {
        this.jdField_a_of_type_Ygh.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Ygh.a(this.jdField_a_of_type_Yga);
        this.jdField_a_of_type_Ygh.a(paramyfy);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Ygh);
      }
      return;
      if ((paramyfy instanceof ygb))
      {
        if (this.jdField_a_of_type_Ygk == null) {
          this.jdField_a_of_type_Ygk = new ygk(super.getContext());
        }
        this.jdField_a_of_type_Ygh = this.jdField_a_of_type_Ygk;
      }
      else
      {
        xvv.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    xvv.b("FaceListPage", "FacePackage is NormalFacePackage");
    yge localyge = (yge)this.jdField_a_of_type_Yfy;
    if (!localyge.jdField_a_of_type_JavaUtilList.isEmpty()) {
      xvv.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localyge.f))
        {
          xvv.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localyge.a();
        }
      }
      if (bool2)
      {
        xvv.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
        postDelayed(new FaceListPage.2(this), 50L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131378207);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_Yfy.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378207, this.jdField_a_of_type_Yfy.d);
        ydf.a().a(super.getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Yfy.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localyge.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localyge.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localyge.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localyge.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localyge.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846402);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = AIOUtils.dp2px(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561597, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366278));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366279));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131373009));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131366265));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131366259));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131370319));
    this.c = ((LinearLayout)super.findViewById(2131370324));
    this.d = ((LinearLayout)super.findViewById(2131370316));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365733));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Yfy == null) {
      xvv.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Yfy.a())) {
            break;
          }
          localObject = (ygb)this.jdField_a_of_type_Yfy;
        } while ((!((ygb)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((ygb)localObject).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
        if (NetworkUtil.isNetworkAvailable(super.getContext())) {
          xwa.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          xwa.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Yfy.a()));
      localObject = (yge)this.jdField_a_of_type_Yfy;
    } while ((!NetworkUtil.isWifiEnabled(getContext())) || (this.jdField_a_of_type_Yfx == null) || (((yge)localObject).jdField_a_of_type_Boolean) || (!((yge)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    xvv.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Yfx.a(((yge)localObject).jdField_a_of_type_JavaLangString);
    xwa.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(yfy paramyfy)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, paramyfy));
    }
    do
    {
      return;
      if (paramyfy == null) {
        break;
      }
      xvv.b("FaceListPage", "onChange,FacePkgInfo:" + paramyfy.toString());
      if ((this.jdField_a_of_type_Yfy == null) || (!this.jdField_a_of_type_Yfy.a().equals(paramyfy.a()))) {
        b(paramyfy);
      }
      this.jdField_a_of_type_Yfy = paramyfy;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Yfy.a()))
      {
        c();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_Yfy.a()));
    b();
    return;
    xvv.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Yfy = null;
    this.jdField_a_of_type_Ygh.a(null);
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
      if (this.jdField_a_of_type_Yfx != null)
      {
        if (((yge)this.jdField_a_of_type_Yfy).jdField_a_of_type_Boolean) {
          break label83;
        }
        xvv.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Yfy.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Yfx.a(this.jdField_a_of_type_Yfy.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      this.jdField_a_of_type_Yfx.b(this.jdField_a_of_type_Yfy.jdField_a_of_type_JavaLangString);
      continue;
      if ((paramView == this.c) && (this.jdField_a_of_type_Yfx != null))
      {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.c.setVisibility(4);
        this.d.setVisibility(0);
        this.jdField_a_of_type_Yfx.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */