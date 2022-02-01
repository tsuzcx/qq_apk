package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face;

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
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.LocationFaceAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.NormalFaceAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.List;
import mqq.os.MqqHandler;

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
  private IFaceSelectedListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener;
  private FacePackage jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage;
  private FaceListPage.FacePackagePageEventListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener;
  private BaseFaceListAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter;
  private InformationFaceAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter;
  private LocationFaceAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
  private NormalFaceAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
  public boolean a;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, IFaceSelectedListener paramIFaceSelectedListener, FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener = paramFacePackagePageEventListener;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener = paramIFaceSelectedListener;
    e();
  }
  
  private boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void b()
  {
    SLog.b("FaceListPage", "FacePackage is InformationFacePackage");
    FacePackage localFacePackage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage;
    if (!(localFacePackage instanceof InformationFacePackage)) {
      return;
    }
    if (!((InformationFacePackage)localFacePackage).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.notifyDataSetChanged();
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
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterNormalFaceAdapter == null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterNormalFaceAdapter = new NormalFaceAdapter(super.getContext(), this);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
    }
    else if ((paramFacePackage instanceof LocationFacePackage))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterLocationFaceAdapter == null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterLocationFaceAdapter = new LocationFaceAdapter(super.getContext(), this);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
    }
    else if ((paramFacePackage instanceof InformationFacePackage))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter == null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter = new InformationFaceAdapter(super.getContext(), this);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter;
    }
    else
    {
      SLog.e("FaceListPage", "FacePackage is illegal.");
    }
    BaseFaceListAdapter localBaseFaceListAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter;
    if (localBaseFaceListAdapter != null)
    {
      localBaseFaceListAdapter.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localBaseFaceListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(paramFacePackage);
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter);
    }
  }
  
  private void c()
  {
    SLog.b("FaceListPage", "FacePackage is LocationFacePackage");
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage;
    if (!(localObject instanceof LocationFacePackage)) {
      return;
    }
    localObject = (LocationFacePackage)localObject;
    if (!((LocationFacePackage)localObject).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.notifyDataSetChanged();
      return;
    }
    if (((LocationFacePackage)localObject).jdField_b_of_type_Boolean)
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
  
  private void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FacePackage is NormalFacePackage ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage);
    SLog.b("FaceListPage", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage;
    if (localObject == null) {
      return;
    }
    if (!(localObject instanceof NormalFacePackage)) {
      return;
    }
    NormalFacePackage localNormalFacePackage = (NormalFacePackage)localObject;
    boolean bool;
    if ((localNormalFacePackage.jdField_a_of_type_JavaUtilList != null) && (!localNormalFacePackage.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      SLog.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((!bool) && (!TextUtils.isEmpty(localNormalFacePackage.g)))
    {
      SLog.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
      localObject = localNormalFacePackage.a();
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else
    {
      localObject = null;
    }
    ThreadManager.getUIHandler().post(new FaceListPage.2(this, localNormalFacePackage, (List)localObject, bool));
  }
  
  private void e()
  {
    this.jdField_b_of_type_Int = AIOUtils.b(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131561655, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366434));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366435));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131373123));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131366421));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131366415));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)super.findViewById(2131370417));
    this.c = ((LinearLayout)super.findViewById(2131370422));
    this.d = ((LinearLayout)super.findViewById(2131370413));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365828));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage;
    if (localObject == null)
    {
      SLog.b("FaceListPage", "onShow : FacePackage is null.");
      return;
    }
    if ("LocationFacePackage".equals(((FacePackage)localObject).a()))
    {
      localObject = (LocationFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage;
      if ((((LocationFacePackage)localObject).jdField_a_of_type_JavaUtilList.isEmpty()) && (!((LocationFacePackage)localObject).jdField_b_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        if (NetworkUtil.isNetworkAvailable(super.getContext())) {
          StoryReportor.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        } else {
          StoryReportor.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
        this.jdField_b_of_type_Boolean = true;
      }
    }
    else if ("NormalFacePackage".equals(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage.a()))
    {
      localObject = (NormalFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage;
      if ((NetworkUtil.isWifiEnabled(getContext())) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener != null) && (!((NormalFacePackage)localObject).jdField_b_of_type_Boolean) && (((NormalFacePackage)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        SLog.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a(((NormalFacePackage)localObject).jdField_a_of_type_JavaLangString);
        StoryReportor.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
      }
    }
  }
  
  public void a(FacePackage paramFacePackage)
  {
    if (!a())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new FaceListPage.1(this, paramFacePackage));
      return;
    }
    if (paramFacePackage != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChange,FacePkgInfo:");
      ((StringBuilder)localObject).append(paramFacePackage.toString());
      SLog.b("FaceListPage", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage;
      if ((localObject == null) || (!((FacePackage)localObject).a().equals(paramFacePackage.a()))) {
        b(paramFacePackage);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage = paramFacePackage;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage.a()))
      {
        d();
        return;
      }
      if ("LocationFacePackage".equals(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage.a()))
      {
        c();
        return;
      }
      if ("InformationFacePackage".equals(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage.a())) {
        b();
      }
    }
    else
    {
      SLog.b("FaceListPage", "onChange, null.");
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage = null;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(null);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    }
  }
  
  public void a(String paramString)
  {
    FacePackage localFacePackage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage;
    int k = 0;
    int j = k;
    if (localFacePackage != null)
    {
      int m = localFacePackage.a();
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= localFacePackage.b()) {
          break;
        }
        String str = localFacePackage.a(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("selectByName : ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(str);
        SLog.b("FaceListPage", localStringBuilder.toString());
        if ((str != null) && (str.contains(paramString)))
        {
          j = i / m;
          break;
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_AndroidWidgetListView.setSelection(j);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetTextView)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener != null)
      {
        if (!((NormalFacePackage)this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage).jdField_b_of_type_Boolean)
        {
          paramView = new StringBuilder();
          paramView.append("Download pkg:");
          paramView.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage.jdField_a_of_type_JavaLangString);
          SLog.b("FaceListPage", paramView.toString());
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage.jdField_a_of_type_JavaLangString);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131704412));
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage.jdField_a_of_type_JavaLangString);
      }
    }
    else if ((paramView == this.c) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener != null))
    {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.c.setVisibility(4);
      this.d.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */