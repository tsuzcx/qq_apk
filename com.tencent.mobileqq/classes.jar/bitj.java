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

public class bitj
  extends Fragment
  implements bisx
{
  public static double a;
  public static List<List<List<PointF>>> a;
  public static List<List<float[]>> b;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private biss jdField_a_of_type_Biss;
  private biuo jdField_a_of_type_Biuo;
  private biur jdField_a_of_type_Biur;
  private bius jdField_a_of_type_Bius;
  private bivb jdField_a_of_type_Bivb;
  private bivc jdField_a_of_type_Bivc;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private List<bisj> c = new ArrayList();
  
  static
  {
    jdField_a_of_type_Double = 1.0D;
  }
  
  public static bitj a(String paramString, long paramLong)
  {
    bitj localbitj = new bitj();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString);
    localBundle.putLong("KEY_AVAILABLE_EMO_COUNT", paramLong);
    localbitj.setArguments(localBundle);
    return localbitj;
  }
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_camera_emo_snapshots", paramArrayList3);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new bits(this));
    getActivity().setResult(201);
    getActivity().finish();
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375453);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = ((int)(DeviceUtils.getScreenHeight(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.08F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367062).setOnClickListener(new bitl(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378372));
    int i = (int)(DeviceUtils.getScreenWidth(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.04F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, bawz.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F), 0, bawz.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375562));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bitm(this));
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375556));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 2));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new bitn(this));
    d();
  }
  
  private void d()
  {
    Object localObject = new bisj();
    ((bisj)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
    ((bisj)localObject).jdField_a_of_type_JavaLangString = null;
    ((bisj)localObject).b = 2;
    this.c.add(0, new bisj());
    this.jdField_a_of_type_Biss = new biss(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this.c);
    this.jdField_a_of_type_Biss.a(this);
    this.jdField_a_of_type_Biss.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Biss);
    localObject = new biuz();
    ((biuz)localObject).a = 0;
    this.jdField_a_of_type_Bivc.a((biuz)localObject);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bius = ((bius)biix.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).a(bius.class));
    this.jdField_a_of_type_Biss.a(this.jdField_a_of_type_Bius, this.jdField_a_of_type_DovComQqImBaseVMPeakActivity);
    this.jdField_a_of_type_Bius.b().a("");
    this.jdField_a_of_type_Bius.a().a(new bism("#ccffffff", "#000000"));
    this.jdField_a_of_type_Bius.c().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new bito(this));
    this.jdField_a_of_type_Bius.a();
    this.jdField_a_of_type_Biuo = ((biuo)biix.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).a(biuo.class));
    this.jdField_a_of_type_Biur = ((biur)biix.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, bjmo.a()).a(biur.class));
    this.jdField_a_of_type_Biur.a().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new bitp(this));
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0);
    localObject = biua.a(this.jdField_a_of_type_JavaLangString, true, (View)localObject);
    getFragmentManager().beginTransaction().add(2131366671, (Fragment)localObject).addToBackStack(null).commit();
  }
  
  protected int a()
  {
    return 2131558519;
  }
  
  public void a()
  {
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_DovComQqImBaseVMPeakActivity = ((BaseVMPeakActivity)getActivity());
    paramBundle = getArguments().getString("KEY_PREVIEW_SOURCE_PATH");
    this.jdField_a_of_type_Long = getArguments().getLong("KEY_AVAILABLE_EMO_COUNT");
    QLog.d("AEGIFChunkPreviewFragment", 4, "availableEmoCount = " + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Bivc = new bivc(paramBundle, jdField_a_of_type_JavaUtilList, jdField_b_of_type_JavaUtilList, jdField_a_of_type_Double, getActivity());
    this.jdField_a_of_type_Bivc.a(new bitk(this));
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", ajyc.a(2131699957));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", ajyc.a(2131699958));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", ajyc.a(2131699963));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", ajyc.a(2131699961));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", ajyc.a(2131699959));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", ajyc.a(2131699966));
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
    bivc localbivc;
    if (this.jdField_a_of_type_Bivc != null)
    {
      localbivc = this.jdField_a_of_type_Bivc;
      if (this.jdField_a_of_type_Boolean) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      localbivc.a(bool);
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    bizc.a().H();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    bizg.a().j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitj
 * JD-Core Version:    0.7.0.1
 */