package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import aekt;
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
import bdee;
import java.util.List;
import wsv;
import wta;
import xai;
import xdh;
import xdi;
import xdk;
import xdl;
import xdo;
import xdr;
import xdu;
import xdy;

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
  private xdh jdField_a_of_type_Xdh;
  private xdi jdField_a_of_type_Xdi;
  private xdk jdField_a_of_type_Xdk;
  private xdr jdField_a_of_type_Xdr;
  private xdu jdField_a_of_type_Xdu;
  private xdy jdField_a_of_type_Xdy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, xdk paramxdk, xdh paramxdh)
  {
    super(paramContext);
    this.jdField_a_of_type_Xdh = paramxdh;
    this.jdField_a_of_type_Xdk = paramxdk;
    d();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    wsv.b("FaceListPage", "FacePackage is LocationFacePackage");
    xdl localxdl = (xdl)this.jdField_a_of_type_Xdi;
    if (!localxdl.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_Xdr.notifyDataSetChanged();
      return;
    }
    if (localxdl.jdField_a_of_type_Boolean)
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
  
  private void b(xdi paramxdi)
  {
    if ((paramxdi instanceof xdo))
    {
      if (this.jdField_a_of_type_Xdy == null) {
        this.jdField_a_of_type_Xdy = new xdy(super.getContext());
      }
      this.jdField_a_of_type_Xdr = this.jdField_a_of_type_Xdy;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Xdr != null)
      {
        this.jdField_a_of_type_Xdr.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Xdr.a(this.jdField_a_of_type_Xdk);
        this.jdField_a_of_type_Xdr.a(paramxdi);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Xdr);
      }
      return;
      if ((paramxdi instanceof xdl))
      {
        if (this.jdField_a_of_type_Xdu == null) {
          this.jdField_a_of_type_Xdu = new xdu(super.getContext());
        }
        this.jdField_a_of_type_Xdr = this.jdField_a_of_type_Xdu;
      }
      else
      {
        wsv.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    wsv.b("FaceListPage", "FacePackage is NormalFacePackage");
    xdo localxdo = (xdo)this.jdField_a_of_type_Xdi;
    if (!localxdo.jdField_a_of_type_JavaUtilList.isEmpty()) {
      wsv.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localxdo.f))
        {
          wsv.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localxdo.a();
        }
      }
      if (bool2)
      {
        wsv.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
        postDelayed(new FaceListPage.2(this), 50L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131377396);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_Xdi.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131377396, this.jdField_a_of_type_Xdi.d);
        xai.a().a(super.getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Xdi.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localxdo.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localxdo.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localxdo.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localxdo.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localxdo.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845965);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = aekt.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561424, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365949));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365950));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131372312));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131365936));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131365929));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131369794));
    this.c = ((LinearLayout)super.findViewById(2131369799));
    this.d = ((LinearLayout)super.findViewById(2131369791));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365420));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Xdi == null) {
      wsv.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_Xdi.a())) {
            break;
          }
          localObject = (xdl)this.jdField_a_of_type_Xdi;
        } while ((!((xdl)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((xdl)localObject).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
        if (bdee.g(super.getContext())) {
          wta.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          wta.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_Xdi.a()));
      localObject = (xdo)this.jdField_a_of_type_Xdi;
    } while ((!bdee.a(getContext())) || (this.jdField_a_of_type_Xdh == null) || (((xdo)localObject).jdField_a_of_type_Boolean) || (!((xdo)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    wsv.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_Xdh.a(((xdo)localObject).jdField_a_of_type_JavaLangString);
    wta.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(xdi paramxdi)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, paramxdi));
    }
    do
    {
      return;
      if (paramxdi == null) {
        break;
      }
      wsv.b("FaceListPage", "onChange,FacePkgInfo:" + paramxdi.toString());
      if ((this.jdField_a_of_type_Xdi == null) || (!this.jdField_a_of_type_Xdi.a().equals(paramxdi.a()))) {
        b(paramxdi);
      }
      this.jdField_a_of_type_Xdi = paramxdi;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_Xdi.a()))
      {
        c();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_Xdi.a()));
    b();
    return;
    wsv.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_Xdi = null;
    this.jdField_a_of_type_Xdr.a(null);
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
      if (this.jdField_a_of_type_Xdh != null)
      {
        if (((xdo)this.jdField_a_of_type_Xdi).jdField_a_of_type_Boolean) {
          break label76;
        }
        wsv.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_Xdi.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Xdh.a(this.jdField_a_of_type_Xdi.jdField_a_of_type_JavaLangString);
      }
    }
    label76:
    while ((paramView != this.c) || (this.jdField_a_of_type_Xdh == null))
    {
      return;
      this.jdField_a_of_type_Xdh.b(this.jdField_a_of_type_Xdi.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_Xdh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */