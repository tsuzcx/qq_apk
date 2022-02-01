package com.tencent.aelight.camera.ae.gif.giftext;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFSmartTextAdapter;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import com.tencent.aelight.camera.aebase.BaseVMPeakActivity;
import com.tencent.aelight.camera.aebase.lifecycle.GlobalViewModelFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AEGIFTextMvp
  implements AEGIFTextListener
{
  public static final List<String> a;
  private int jdField_a_of_type_Int = 0;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private StaggeredGridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEGIFOutlineTextView jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView;
  private AEGIFSmartTextAdapter jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter;
  private AEGIFRecommandTextViewModel jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFRecommandTextViewModel;
  private BaseVMPeakActivity jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { HardCodeUtil.a(2131700199), HardCodeUtil.a(2131700210), HardCodeUtil.a(2131700208), HardCodeUtil.a(2131700215), HardCodeUtil.a(2131700219), HardCodeUtil.a(2131700216), "dbq", "886", HardCodeUtil.a(2131700213), HardCodeUtil.a(2131700212), HardCodeUtil.a(2131700203), "ok", "666", HardCodeUtil.a(2131700205), HardCodeUtil.a(2131700222), HardCodeUtil.a(2131700214) });
  }
  
  public AEGIFTextMvp(BaseVMPeakActivity paramBaseVMPeakActivity, RelativeLayout paramRelativeLayout, AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity = paramBaseVMPeakActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    paramBaseVMPeakActivity = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (paramBaseVMPeakActivity != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBaseVMPeakActivity.findViewById(2064122529));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2064122619));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2064122530));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2064122526));
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView = paramAEGIFOutlineTextView;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", HardCodeUtil.a(2131700224));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", HardCodeUtil.a(2131700200));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", HardCodeUtil.a(2131700206));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", HardCodeUtil.a(2131700217));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", HardCodeUtil.a(2131700209));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", HardCodeUtil.a(2131700204));
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setText(paramString1);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    int i;
    if (paramString1.indexOf('\n') > 0) {
      i = DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 73.199997F);
    } else {
      i = DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 41.0F);
    }
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setTextColor(paramString2);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramString3);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 4.0F));
    if (paramString1.indexOf('\n') > 0) {
      i = DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 26.0F);
    } else {
      i = DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 30.0F);
    }
    float f = i;
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setTextSize(f);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.invalidate();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFRecommandTextViewModel = ((AEGIFRecommandTextViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, GlobalViewModelFactory.a()).get(AEGIFRecommandTextViewModel.class));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<AEGIFSmartTextData> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new AEGIFSmartTextData((String)localIterator.next()));
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 0);
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.setGapStrategy(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    e();
    c();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString))
    {
      AEGIFSmartTextAdapter localAEGIFSmartTextAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter;
      if (localAEGIFSmartTextAdapter != null) {
        localAEGIFSmartTextAdapter.a();
      }
    }
    b(paramString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2064056631);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setTextColor(paramString2);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramString3);
    a(paramString1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setStroke(paramBoolean1);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setShadow(paramBoolean2);
  }
  
  public void b()
  {
    Log.d("AEGIFTextMvp", "On loading completed...");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter = new AEGIFSmartTextAdapter(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, this);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter.setHasStableIds(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setClipToPadding(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setClipChildren(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new AEGIFTextMvp.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEGIFTextMvp.2(this));
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setText(paramString);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 4.0F));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    AEGIFOutlineTextView localAEGIFOutlineTextView = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView;
    int i;
    if (paramString.indexOf('\n') > 0) {
      i = DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 26.0F);
    } else {
      i = DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 30.0F);
    }
    localAEGIFOutlineTextView.setTextSize(i);
    if (paramString.indexOf('\n') > 0) {
      i = DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 73.199997F);
    } else {
      i = DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, 41.0F);
    }
    localLayoutParams.height = i;
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setLayoutParams(localLayoutParams);
  }
  
  public void c()
  {
    Log.d("AEGIFTextMvp", "On loading...");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    d();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFRecommandTextViewModel.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAebaseBaseVMPeakActivity, new AEGIFTextMvp.3(this));
  }
  
  public void d()
  {
    Log.d("AEGIFTextMvp", "Clearing smart text");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2064056632);
    AEGIFSmartTextAdapter localAEGIFSmartTextAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFSmartTextAdapter;
    if (localAEGIFSmartTextAdapter != null) {
      localAEGIFSmartTextAdapter.a();
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    a(false, true);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
    b(HardCodeUtil.a(2131700220), "#ccffffff", "#000000");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp
 * JD-Core Version:    0.7.0.1
 */