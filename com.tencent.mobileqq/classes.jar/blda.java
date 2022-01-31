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

public class blda
  extends Fragment
  implements blco
{
  public static double a;
  public static List<List<List<PointF>>> a;
  public static List<List<float[]>> b;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blcj jdField_a_of_type_Blcj;
  private bleg jdField_a_of_type_Bleg;
  private blej jdField_a_of_type_Blej;
  private blek jdField_a_of_type_Blek;
  private blet jdField_a_of_type_Blet;
  private bleu jdField_a_of_type_Bleu;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private List<blca> c = new ArrayList();
  
  static
  {
    jdField_a_of_type_Double = 1.0D;
  }
  
  public static blda a(String paramString, long paramLong)
  {
    blda localblda = new blda();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString);
    localBundle.putLong("KEY_AVAILABLE_EMO_COUNT", paramLong);
    localblda.setArguments(localBundle);
    return localblda;
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
    if ((this.c.get(paramInt) == null) || (((blca)this.c.get(paramInt)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial == null)) {
      return null;
    }
    return ((blca)this.c.get(paramInt)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id;
  }
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_camera_emo_snapshots", paramArrayList3);
    localBundle.putStringArrayList("qipc_param_emo_widget_infos", paramArrayList4);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new bldj(this));
    getActivity().setResult(201);
    getActivity().finish();
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375995);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = ((int)(DeviceUtils.getScreenHeight(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.08F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367199).setOnClickListener(new bldc(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379035));
    int i = (int)(DeviceUtils.getScreenWidth(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.04F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, bdaq.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F), 0, bdaq.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376108));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bldd(this));
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376102));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 2));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new blde(this));
    d();
  }
  
  private void d()
  {
    Object localObject = new blca();
    ((blca)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
    ((blca)localObject).jdField_a_of_type_JavaLangString = null;
    ((blca)localObject).b = 2;
    this.c.add(0, new blca());
    this.jdField_a_of_type_Blcj = new blcj(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this.c);
    this.jdField_a_of_type_Blcj.a(this);
    this.jdField_a_of_type_Blcj.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Blcj);
    localObject = new bler();
    ((bler)localObject).a = 0;
    this.jdField_a_of_type_Bleu.a((bler)localObject);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Blek = ((blek)bkpx.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).a(blek.class));
    this.jdField_a_of_type_Blcj.a(this.jdField_a_of_type_Blek, this.jdField_a_of_type_DovComQqImBaseVMPeakActivity);
    this.jdField_a_of_type_Blek.b().a("");
    this.jdField_a_of_type_Blek.a().a(new blcd("#ccffffff", "#000000"));
    this.jdField_a_of_type_Blek.c().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new bldf(this));
    this.jdField_a_of_type_Blek.a();
    this.jdField_a_of_type_Bleg = ((bleg)bkpx.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).a(bleg.class));
    this.jdField_a_of_type_Blej = ((blej)bkpx.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, bmda.a()).a(blej.class));
    this.jdField_a_of_type_Blej.a().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new bldg(this));
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0);
    localObject = blds.a(this.jdField_a_of_type_JavaLangString, true, (View)localObject);
    getFragmentManager().beginTransaction().add(2131366799, (Fragment)localObject).addToBackStack(null).commit();
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
    this.jdField_a_of_type_Bleu = new bleu(paramBundle, jdField_a_of_type_JavaUtilList, jdField_b_of_type_JavaUtilList, jdField_a_of_type_Double, getActivity());
    this.jdField_a_of_type_Bleu.a(new bldb(this));
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", alud.a(2131700349));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", alud.a(2131700350));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", alud.a(2131700355));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", alud.a(2131700353));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", alud.a(2131700351));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", alud.a(2131700358));
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
    bleu localbleu;
    if (this.jdField_a_of_type_Bleu != null)
    {
      localbleu = this.jdField_a_of_type_Bleu;
      if (this.jdField_a_of_type_Boolean) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      localbleu.a(bool);
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    bliu.a().P();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    bliy.a().i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blda
 * JD-Core Version:    0.7.0.1
 */