import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.giftext.AEGIFOutlineTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bhsk
{
  public static final List<String> a;
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private StaggeredGridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhsw jdField_a_of_type_Bhsw;
  private bhup jdField_a_of_type_Bhup;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { ajjy.a(2131634181), ajjy.a(2131634192), ajjy.a(2131634190), ajjy.a(2131634197), ajjy.a(2131634201), ajjy.a(2131634198), "dbq", "886", ajjy.a(2131634195), ajjy.a(2131634194), ajjy.a(2131634185), "ok", "666", ajjy.a(2131634187), ajjy.a(2131634204), ajjy.a(2131634196) });
  }
  
  public bhsk(BaseVMPeakActivity paramBaseVMPeakActivity, RelativeLayout paramRelativeLayout, AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    this.jdField_a_of_type_DovComQqImBaseVMPeakActivity = paramBaseVMPeakActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131307136));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131310506));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131307137));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131307133));
    }
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView = paramAEGIFOutlineTextView;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", ajjy.a(2131634206));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", ajjy.a(2131634182));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", ajjy.a(2131634188));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", ajjy.a(2131634199));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", ajjy.a(2131634191));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", ajjy.a(2131634186));
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setText(paramString1);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.getLayoutParams();
    int i;
    if (paramString1.indexOf('\n') > 0)
    {
      i = azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 73.199997F);
      localLayoutParams.height = i;
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setTextColor(paramString2);
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setOutlineColor(paramString3);
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setOutlineWidth(azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 4.0F));
      if (paramString1.indexOf('\n') <= 0) {
        break label137;
      }
    }
    label137:
    for (float f = azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 26.0F);; f = azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 30.0F))
    {
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setTextSize(f);
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.invalidate();
      return;
      i = azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 41.0F);
      break;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bhup = ((bhup)bhur.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, bhut.a()).a(bhup.class));
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
  
  public ArrayList<bhsg> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new bhsg((String)localIterator.next()));
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
    if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) && (this.jdField_a_of_type_Bhsw != null)) {
      this.jdField_a_of_type_Bhsw.a();
    }
    b(paramString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839658);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setTextColor(paramString2);
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setOutlineColor(paramString3);
    a(paramString1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setStroke(paramBoolean1);
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setShadow(paramBoolean2);
  }
  
  public void b()
  {
    Log.d(toString(), "On loading completed...");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_Bhsw = new bhsw(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this);
    this.jdField_a_of_type_Bhsw.setHasStableIds(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bhsw);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setClipToPadding(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setClipChildren(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new bhsl(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bhsm(this));
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setText(paramString);
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setOutlineWidth(azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 4.0F));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.getLayoutParams();
    AEGIFOutlineTextView localAEGIFOutlineTextView = this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView;
    float f;
    if (paramString.indexOf('\n') > 0)
    {
      f = azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 26.0F);
      localAEGIFOutlineTextView.setTextSize(f);
      if (paramString.indexOf('\n') <= 0) {
        break label114;
      }
    }
    label114:
    for (int i = azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 73.199997F);; i = azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 41.0F))
    {
      localLayoutParams.height = i;
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setLayoutParams(localLayoutParams);
      return;
      f = azvv.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 30.0F);
      break;
    }
  }
  
  public void c()
  {
    Log.d(toString(), "On loading...");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    d();
    this.jdField_a_of_type_Bhup.a().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new bhsn(this));
  }
  
  public void d()
  {
    Log.d("AEGIFTextMvp", "Clearing smart text");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839659);
    if (this.jdField_a_of_type_Bhsw != null) {
      this.jdField_a_of_type_Bhsw.a();
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    a(false, true);
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
    b(ajjy.a(2131634202), "#ccffffff", "#000000");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhsk
 * JD-Core Version:    0.7.0.1
 */