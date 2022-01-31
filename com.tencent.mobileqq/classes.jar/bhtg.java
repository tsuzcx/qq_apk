import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.BaseVMPeakActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bhtg
  extends Fragment
  implements bhsu
{
  public static double a;
  public static List<List<List<PointF>>> a;
  public static List<List<float[]>> b;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhsp jdField_a_of_type_Bhsp;
  private bhum jdField_a_of_type_Bhum;
  private bhup jdField_a_of_type_Bhup;
  private bhuq jdField_a_of_type_Bhuq;
  private bial jdField_a_of_type_Bial;
  private biam jdField_a_of_type_Biam;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 10000L;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private biam jdField_b_of_type_Biam;
  private long jdField_c_of_type_Long = 9223372036854775807L;
  private List<bhsf> jdField_c_of_type_JavaUtilList = new ArrayList();
  private List<biaj> d = new ArrayList();
  private List<Integer> e = new ArrayList();
  private List<Integer> f = new ArrayList();
  
  static
  {
    jdField_a_of_type_Double = 1.0D;
  }
  
  public static bhtg a(String paramString, long paramLong)
  {
    bhtg localbhtg = new bhtg();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString);
    localBundle.putLong("KEY_AVAILABLE_EMO_COUNT", paramLong);
    localbhtg.setArguments(localBundle);
    return localbhtg;
  }
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_camera_emo_snapshots", paramArrayList3);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new bhtq(this));
    getActivity().setResult(201);
    getActivity().finish();
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131309698);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = ((int)(DeviceUtils.getScreenHeight(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.08F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301452).setOnClickListener(new bhtj(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312547));
    int i = (int)(DeviceUtils.getScreenWidth(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.04F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F), 0, azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131309803));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bhtk(this));
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131309796));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 2));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new bhtl(this));
    d();
  }
  
  private void d()
  {
    Object localObject = new bhsf();
    ((bhsf)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
    ((bhsf)localObject).jdField_a_of_type_JavaLangString = null;
    ((bhsf)localObject).jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_JavaUtilList.add(0, new bhsf());
    this.jdField_a_of_type_Bhsp = new bhsp(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this.jdField_c_of_type_JavaUtilList);
    this.jdField_a_of_type_Bhsp.a(this);
    this.jdField_a_of_type_Bhsp.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bhsp);
    localObject = new biaj();
    ((biaj)localObject).jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Biam.a((biaj)localObject);
    this.d.add(localObject);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bhuq = ((bhuq)bhur.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).a(bhuq.class));
    this.jdField_a_of_type_Bhsp.a(this.jdField_a_of_type_Bhuq, this.jdField_a_of_type_DovComQqImBaseVMPeakActivity);
    this.jdField_a_of_type_Bhuq.b().a("");
    this.jdField_a_of_type_Bhuq.a().a(new bhsi("#ccffffff", "#000000"));
    this.jdField_a_of_type_Bhuq.c().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new bhtm(this));
    this.jdField_a_of_type_Bhuq.a();
    this.jdField_a_of_type_Bhum = ((bhum)bhur.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).a(bhum.class));
    this.jdField_a_of_type_Bhup = ((bhup)bhur.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, bhut.a()).a(bhup.class));
    this.jdField_a_of_type_Bhup.a().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new bhtn(this));
  }
  
  private void f()
  {
    if (this.e.size() == this.jdField_a_of_type_Int) {
      return;
    }
    int i = this.jdField_b_of_type_Int;
    while (i < this.e.size())
    {
      this.jdField_b_of_type_Biam.a((biaj)this.d.get(i));
      i += 1;
    }
    this.jdField_b_of_type_Int = this.e.size();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    i = 0;
    while (i < this.f.size())
    {
      this.jdField_a_of_type_Biam.a((biaj)this.d.get(((Integer)this.f.get(i)).intValue()));
      i += 1;
    }
    this.f.clear();
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0);
    localObject = bhty.a(this.jdField_a_of_type_JavaLangString, true, (View)localObject);
    getFragmentManager().beginTransaction().add(2131301060, (Fragment)localObject).addToBackStack(null).commit();
  }
  
  protected int a()
  {
    return 2131492968;
  }
  
  public void a()
  {
    g();
  }
  
  public boolean a()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > this.jdField_b_of_type_Long)
    {
      QLog.e("AEGIFChunkPreviewFragment", 4, "[checkFirstFrameTimeOut] is timeout");
      return true;
    }
    QLog.i("AEGIFChunkPreviewFragment", 4, "[checkFirstFrameTimeOut] not timeout");
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_DovComQqImBaseVMPeakActivity = ((BaseVMPeakActivity)getActivity());
    paramBundle = getArguments().getString("KEY_PREVIEW_SOURCE_PATH");
    this.jdField_c_of_type_Long = getArguments().getLong("KEY_AVAILABLE_EMO_COUNT");
    QLog.d("AEGIFChunkPreviewFragment", 4, "availableEmoCount = " + this.jdField_c_of_type_Long);
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Biam = new biam(paramBundle, jdField_a_of_type_JavaUtilList, jdField_b_of_type_JavaUtilList, jdField_a_of_type_Double, true, getActivity());
    this.jdField_a_of_type_Biam.a(new bhth(this));
    this.jdField_b_of_type_Biam = new biam(paramBundle, jdField_a_of_type_JavaUtilList, jdField_b_of_type_JavaUtilList, jdField_a_of_type_Double, false, getActivity());
    this.jdField_b_of_type_Biam.a(new bhti(this));
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", ajjy.a(2131634169));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", ajjy.a(2131634170));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", ajjy.a(2131634175));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", ajjy.a(2131634173));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", ajjy.a(2131634171));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", ajjy.a(2131634178));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    b();
    e();
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Biam != null) {
        this.jdField_a_of_type_Biam.a(true);
      }
      if (this.jdField_b_of_type_Biam != null) {
        this.jdField_b_of_type_Biam.a(true);
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    bhci.a().F();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    bhcm.a().j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhtg
 * JD-Core Version:    0.7.0.1
 */