import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.BaseVMPeakActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bkyt
  extends Fragment
  implements bkyh
{
  public static double a;
  public static List<List<List<PointF>>> a;
  public static List<List<float[]>> b;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkyc jdField_a_of_type_Bkyc;
  private bkzz jdField_a_of_type_Bkzz;
  private blac jdField_a_of_type_Blac;
  private blad jdField_a_of_type_Blad;
  private blam jdField_a_of_type_Blam;
  private blan jdField_a_of_type_Blan;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private List<bkxt> c = new ArrayList();
  
  static
  {
    jdField_a_of_type_Double = 1.0D;
  }
  
  public static bkyt a(String paramString, long paramLong)
  {
    bkyt localbkyt = new bkyt();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString);
    localBundle.putLong("KEY_AVAILABLE_EMO_COUNT", paramLong);
    localbkyt.setArguments(localBundle);
    return localbkyt;
  }
  
  @Nullable
  private String a(int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.c.size())) {
      return null;
    }
    if ((this.c.get(paramInt) == null) || (((bkxt)this.c.get(paramInt)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial == null)) {
      return null;
    }
    return ((bkxt)this.c.get(paramInt)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id;
  }
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_camera_emo_snapshots", paramArrayList3);
    localBundle.putStringArrayList("qipc_param_emo_widget_infos", paramArrayList4);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new bkzc(this));
    getActivity().setResult(201);
    getActivity().finish();
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375942);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = ((int)(DeviceUtils.getScreenHeight(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.08F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367189).setOnClickListener(new bkyv(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378977));
    int i = (int)(DeviceUtils.getScreenWidth(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.04F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, bcwh.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F), 0, bcwh.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376054));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bkyw(this));
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376048));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 2));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new bkyx(this));
    d();
  }
  
  private void d()
  {
    Object localObject = new bkxt();
    ((bkxt)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
    ((bkxt)localObject).jdField_a_of_type_JavaLangString = null;
    ((bkxt)localObject).b = 2;
    this.c.add(0, new bkxt());
    this.jdField_a_of_type_Bkyc = new bkyc(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this.c);
    this.jdField_a_of_type_Bkyc.a(this);
    this.jdField_a_of_type_Bkyc.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bkyc);
    localObject = new blak();
    ((blak)localObject).a = 0;
    this.jdField_a_of_type_Blan.a((blak)localObject);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Blad = ((blad)bklq.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).a(blad.class));
    this.jdField_a_of_type_Bkyc.a(this.jdField_a_of_type_Blad, this.jdField_a_of_type_DovComQqImBaseVMPeakActivity);
    this.jdField_a_of_type_Blad.b().a("");
    this.jdField_a_of_type_Blad.a().a(new bkxw("#ccffffff", "#000000"));
    this.jdField_a_of_type_Blad.c().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new bkyy(this));
    this.jdField_a_of_type_Blad.a();
    this.jdField_a_of_type_Bkzz = ((bkzz)bklq.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).a(bkzz.class));
    this.jdField_a_of_type_Blac = ((blac)bklq.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, blyo.a()).a(blac.class));
    this.jdField_a_of_type_Blac.a().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new bkyz(this));
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0);
    localObject = bkzl.a(this.jdField_a_of_type_JavaLangString, true, (View)localObject);
    getFragmentManager().beginTransaction().add(2131366789, (Fragment)localObject).addToBackStack(null).commit();
  }
  
  protected int a()
  {
    return 2131558543;
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
    this.jdField_a_of_type_Blan = new blan(paramBundle, jdField_a_of_type_JavaUtilList, jdField_b_of_type_JavaUtilList, jdField_a_of_type_Double, getActivity());
    this.jdField_a_of_type_Blan.a(new bkyu(this));
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", alpo.a(2131700337));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", alpo.a(2131700338));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", alpo.a(2131700343));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", alpo.a(2131700341));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", alpo.a(2131700339));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", alpo.a(2131700346));
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
    blan localblan;
    if (this.jdField_a_of_type_Blan != null)
    {
      localblan = this.jdField_a_of_type_Blan;
      if (this.jdField_a_of_type_Boolean) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      localblan.a(bool);
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    blen.a().P();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    bler.a().i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyt
 * JD-Core Version:    0.7.0.1
 */