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

public class biua
  extends Fragment
  implements bito
{
  public static double a;
  public static List<List<List<PointF>>> a;
  public static List<List<float[]>> b;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bitj jdField_a_of_type_Bitj;
  private bivf jdField_a_of_type_Bivf;
  private bivi jdField_a_of_type_Bivi;
  private bivj jdField_a_of_type_Bivj;
  private bivs jdField_a_of_type_Bivs;
  private bivt jdField_a_of_type_Bivt;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private List<bita> c = new ArrayList();
  
  static
  {
    jdField_a_of_type_Double = 1.0D;
  }
  
  public static biua a(String paramString, long paramLong)
  {
    biua localbiua = new biua();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString);
    localBundle.putLong("KEY_AVAILABLE_EMO_COUNT", paramLong);
    localbiua.setArguments(localBundle);
    return localbiua;
  }
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_camera_emo_snapshots", paramArrayList3);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new biuj(this));
    getActivity().setResult(201);
    getActivity().finish();
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375455);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = ((int)(DeviceUtils.getScreenHeight(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.08F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367062).setOnClickListener(new biuc(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378375));
    int i = (int)(DeviceUtils.getScreenWidth(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.04F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F), 0, baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375564));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new biud(this));
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375558));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 2));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new biue(this));
    d();
  }
  
  private void d()
  {
    Object localObject = new bita();
    ((bita)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
    ((bita)localObject).jdField_a_of_type_JavaLangString = null;
    ((bita)localObject).b = 2;
    this.c.add(0, new bita());
    this.jdField_a_of_type_Bitj = new bitj(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this.c);
    this.jdField_a_of_type_Bitj.a(this);
    this.jdField_a_of_type_Bitj.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bitj);
    localObject = new bivq();
    ((bivq)localObject).a = 0;
    this.jdField_a_of_type_Bivt.a((bivq)localObject);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bivj = ((bivj)bijo.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).a(bivj.class));
    this.jdField_a_of_type_Bitj.a(this.jdField_a_of_type_Bivj, this.jdField_a_of_type_DovComQqImBaseVMPeakActivity);
    this.jdField_a_of_type_Bivj.b().a("");
    this.jdField_a_of_type_Bivj.a().a(new bitd("#ccffffff", "#000000"));
    this.jdField_a_of_type_Bivj.c().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new biuf(this));
    this.jdField_a_of_type_Bivj.a();
    this.jdField_a_of_type_Bivf = ((bivf)bijo.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).a(bivf.class));
    this.jdField_a_of_type_Bivi = ((bivi)bijo.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, bjnf.a()).a(bivi.class));
    this.jdField_a_of_type_Bivi.a().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new biug(this));
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0);
    localObject = biur.a(this.jdField_a_of_type_JavaLangString, true, (View)localObject);
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
    this.jdField_a_of_type_Bivt = new bivt(paramBundle, jdField_a_of_type_JavaUtilList, jdField_b_of_type_JavaUtilList, jdField_a_of_type_Double, getActivity());
    this.jdField_a_of_type_Bivt.a(new biub(this));
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", ajya.a(2131699968));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", ajya.a(2131699969));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", ajya.a(2131699974));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", ajya.a(2131699972));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", ajya.a(2131699970));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", ajya.a(2131699977));
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
    bivt localbivt;
    if (this.jdField_a_of_type_Bivt != null)
    {
      localbivt = this.jdField_a_of_type_Bivt;
      if (this.jdField_a_of_type_Boolean) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      localbivt.a(bool);
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    bizt.a().H();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    bizx.a().j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biua
 * JD-Core Version:    0.7.0.1
 */