import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class botw
  extends ReportFragment
  implements botk
{
  public static double a;
  public static List<List<List<PointF>>> a;
  public static List<List<float[]>> b;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private botf jdField_a_of_type_Botf;
  private bovb jdField_a_of_type_Bovb;
  private bovd jdField_a_of_type_Bovd;
  private bove jdField_a_of_type_Bove;
  private bovn jdField_a_of_type_Bovn;
  private bovo jdField_a_of_type_Bovo;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private List<bosw> c = new ArrayList();
  
  static
  {
    jdField_a_of_type_Double = 1.0D;
  }
  
  public static botw a(String paramString1, long paramLong, String paramString2)
  {
    botw localbotw = new botw();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString1);
    localBundle.putLong("KEY_AVAILABLE_EMO_COUNT", paramLong);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("KEY_FONT_ID", paramString2);
    }
    localbotw.setArguments(localBundle);
    return localbotw;
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
    if ((this.c.get(paramInt) == null) || (((bosw)this.c.get(paramInt)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial == null)) {
      return null;
    }
    return ((bosw)this.c.get(paramInt)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id;
  }
  
  private void a(@NonNull bosp parambosp)
  {
    bpam.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion] - BEGIN -");
    Object localObject1 = boqm.a().a(3).iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (AEGifCategoryWrapper)((Iterator)localObject1).next();
    } while ((localObject2 == null) || (TextUtils.isEmpty(((AEGifCategoryWrapper)localObject2).categoryName)) || (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject2).materialWrapperList)) || (!((AEGifCategoryWrapper)localObject2).categoryName.equals(parambosp.jdField_a_of_type_JavaLangString)));
    for (localObject1 = ((AEGifCategoryWrapper)localObject2).materialWrapperList;; localObject1 = null)
    {
      int j;
      int i;
      if (localObject1 == null)
      {
        bpam.d("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], matchedMaterialList == null");
        if ((localObject1 != null) && (this.c != null))
        {
          bpam.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], matchedMaterialList.size() = " + ((List)localObject1).size());
          j = Math.min(((List)localObject1).size(), parambosp.b);
          Collections.shuffle((List)localObject1);
          i = 0;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          parambosp = (boqw)((List)localObject1).get(i);
          localObject2 = new bosw();
          ((bosw)localObject2).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = parambosp.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
          bpam.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], sssigning material to item index = " + i + "material id = " + parambosp.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          ((bosw)localObject2).b = 0;
          ((bosw)localObject2).jdField_a_of_type_Int = 10;
          ((bosw)localObject2).jdField_a_of_type_JavaLangString = "";
          bozr.a().k(parambosp.jdField_a_of_type_JavaLangString);
          if (this.c.size() < this.jdField_a_of_type_Long) {}
        }
        else
        {
          bpam.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion] - BEGIN -");
          return;
          if (!((List)localObject1).isEmpty()) {
            break;
          }
          bpam.d("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], aeMaterialWrappers is empty");
          break;
        }
        this.c.add(localObject2);
        this.jdField_a_of_type_Botf.notifyItemInserted(this.c.size() - 1);
        this.jdField_a_of_type_Bovb.a(bplg.a(), (bosw)localObject2);
        i += 1;
      }
    }
  }
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_camera_emo_snapshots", paramArrayList3);
    localBundle.putStringArrayList("qipc_param_emo_widget_infos", paramArrayList4);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new boue(this));
    getActivity().setResult(201);
    getActivity().finish();
    paramArrayList1 = getActivity().getApplicationContext();
    ThreadManager.getUIHandler().post(new AEGIFChunkPreviewFragment.8(this, paramArrayList1));
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376880);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = ((int)(DeviceUtils.getScreenHeight(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.08F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367553).setOnClickListener(new boty(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380128));
    int i = (int)(DeviceUtils.getScreenWidth(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.04F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, bhgr.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F), 0, bhgr.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377006));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new botz(this));
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376998));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 2));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new boua(this));
    d();
  }
  
  private void d()
  {
    Object localObject = new bosw();
    ((bosw)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
    ((bosw)localObject).jdField_a_of_type_JavaLangString = null;
    ((bosw)localObject).b = 2;
    this.c.add(0, new bosw());
    this.jdField_a_of_type_Botf = new botf(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this.c, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Botf.a(this);
    this.jdField_a_of_type_Botf.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Botf);
    localObject = new bovl();
    ((bovl)localObject).jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bovo.a((bovl)localObject);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bove = ((bove)bofz.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).get(bove.class));
    this.jdField_a_of_type_Botf.a(this.jdField_a_of_type_Bove, this.jdField_a_of_type_DovComQqImBaseVMPeakActivity);
    this.jdField_a_of_type_Bove.b().postValue("");
    this.jdField_a_of_type_Bove.a().postValue(new bosz("#ccffffff", "#000000"));
    this.jdField_a_of_type_Bove.c().observe(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new boub(this));
    this.jdField_a_of_type_Bove.a();
    this.jdField_a_of_type_Bovb = ((bovb)bofz.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).get(bovb.class));
    this.jdField_a_of_type_Bovd = ((bovd)bofz.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, bpxz.a()).get(bovd.class));
    this.jdField_a_of_type_Bovd.a().observe(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new bouc(this));
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0);
    localObject = boun.a(this.jdField_b_of_type_JavaLangString, true, (View)localObject, this.jdField_a_of_type_JavaLangString);
    getFragmentManager().beginTransaction().add(2131367118, (Fragment)localObject).addToBackStack(null).commit();
  }
  
  protected int a()
  {
    return 2131558572;
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
    if (getArguments().containsKey("KEY_FONT_ID")) {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("KEY_FONT_ID");
    }
    this.jdField_a_of_type_Bovo = new bovo(paramBundle, jdField_a_of_type_JavaUtilList, jdField_b_of_type_JavaUtilList, jdField_a_of_type_Double, this.jdField_a_of_type_JavaLangString, getActivity());
    this.jdField_a_of_type_Bovo.a(new botx(this));
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", anzj.a(2131698882));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", anzj.a(2131698883));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", anzj.a(2131698888));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", anzj.a(2131698886));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", anzj.a(2131698884));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", anzj.a(2131698891));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    b();
    e();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bovo localbovo;
    if (this.jdField_a_of_type_Bovo != null)
    {
      localbovo = this.jdField_a_of_type_Bovo;
      if (this.jdField_a_of_type_Boolean) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      localbovo.a(bool);
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    bozr.a().ag();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    bozv.a().i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botw
 * JD-Core Version:    0.7.0.1
 */