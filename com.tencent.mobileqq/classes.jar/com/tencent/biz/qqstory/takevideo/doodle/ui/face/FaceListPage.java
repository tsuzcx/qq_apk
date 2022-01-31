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
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.loader.ImageLoader;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LocationFaceAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.List;
import okd;
import oke;

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
  private FaceListPage.FacePackagePageEventListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener;
  private FacePackage jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
  private FacePanel.OnFaceSelectedListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener;
  private BaseFaceListAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter;
  private LocationFaceAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
  private NormalFaceAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, FacePanel.OnFaceSelectedListener paramOnFaceSelectedListener, FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener = paramFacePackagePageEventListener;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener = paramOnFaceSelectedListener;
    d();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    SLog.b("FaceListPage", "FacePackage is LocationFacePackage");
    LocationFacePackage localLocationFacePackage = (LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
    if (!localLocationFacePackage.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.notifyDataSetChanged();
      return;
    }
    if (localLocationFacePackage.jdField_a_of_type_Boolean)
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
  
  private void b(FacePackage paramFacePackage)
  {
    if ((paramFacePackage instanceof NormalFacePackage))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter = new NormalFaceAdapter(super.getContext());
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(paramFacePackage);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter);
      }
      return;
      if ((paramFacePackage instanceof LocationFacePackage))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter = new LocationFaceAdapter(super.getContext());
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
      }
      else
      {
        SLog.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    SLog.b("FaceListPage", "FacePackage is NormalFacePackage");
    NormalFacePackage localNormalFacePackage = (NormalFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
    if (!localNormalFacePackage.jdField_a_of_type_JavaUtilList.isEmpty()) {
      SLog.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localNormalFacePackage.f))
        {
          SLog.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localNormalFacePackage.a();
        }
      }
      if (bool2)
      {
        SLog.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
        postDelayed(new oke(this), 50L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131362360);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131362360, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.d);
        ImageLoader.a().a(super.getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localNormalFacePackage.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localNormalFacePackage.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localNormalFacePackage.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localNormalFacePackage.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localNormalFacePackage.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843452);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = AIOUtils.a(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2130970718, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371709));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371710));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131363005));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131371707));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131371708));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131371721));
    this.c = ((LinearLayout)super.findViewById(2131371722));
    this.d = ((LinearLayout)super.findViewById(2131371723));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363518));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) {
      SLog.d("FaceListPage", "onShow : FacePackage is null.");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"LocationFacePackage".equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a())) {
            break;
          }
          localObject = (LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
        } while ((!((LocationFacePackage)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) || (((LocationFacePackage)localObject).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
        if (NetworkUtil.g(super.getContext())) {
          StoryReportor.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
          StoryReportor.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
      } while (!"NormalFacePackage".equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a()));
      localObject = (NormalFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
    } while ((!NetworkUtil.a(getContext())) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener == null) || (((NormalFacePackage)localObject).jdField_a_of_type_Boolean) || (!((NormalFacePackage)localObject).jdField_a_of_type_JavaUtilList.isEmpty()));
    SLog.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a(((NormalFacePackage)localObject).jdField_a_of_type_JavaLangString);
    StoryReportor.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
  }
  
  public void a(FacePackage paramFacePackage)
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new okd(this, paramFacePackage));
    }
    do
    {
      return;
      if (paramFacePackage == null) {
        break;
      }
      SLog.b("FaceListPage", "onChange,FacePkgInfo:" + paramFacePackage.toString());
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a().equals(paramFacePackage.a()))) {
        b(paramFacePackage);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage = paramFacePackage;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a()))
      {
        c();
        return;
      }
    } while (!"LocationFacePackage".equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a()));
    b();
    return;
    SLog.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(null);
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
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener != null)
      {
        if (((NormalFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).jdField_a_of_type_Boolean) {
          break label76;
        }
        SLog.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.jdField_a_of_type_JavaLangString);
      }
    }
    label76:
    while ((paramView != this.c) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener == null))
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */