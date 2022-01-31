import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bitf
{
  public static final List<String> a;
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private StaggeredGridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bitq jdField_a_of_type_Bitq;
  private bivi jdField_a_of_type_Bivi;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { ajya.a(2131699980), ajya.a(2131699991), ajya.a(2131699989), ajya.a(2131699996), ajya.a(2131700000), ajya.a(2131699997), "dbq", "886", ajya.a(2131699994), ajya.a(2131699993), ajya.a(2131699984), "ok", "666", ajya.a(2131699986), ajya.a(2131700003), ajya.a(2131699995) });
  }
  
  public bitf(BaseVMPeakActivity paramBaseVMPeakActivity, RelativeLayout paramRelativeLayout, AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    this.jdField_a_of_type_DovComQqImBaseVMPeakActivity = paramBaseVMPeakActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372850));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376300));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372851));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372847));
    }
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = paramAEGIFOutlineTextView;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", ajya.a(2131700005));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", ajya.a(2131699981));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", ajya.a(2131699987));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", ajya.a(2131699998));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", ajya.a(2131699990));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", ajya.a(2131699985));
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(paramString1);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    int i;
    if (paramString1.indexOf('\n') > 0)
    {
      i = baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 73.199997F);
      localLayoutParams.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextColor(paramString2);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramString3);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 4.0F));
      if (paramString1.indexOf('\n') <= 0) {
        break label137;
      }
    }
    label137:
    for (float f = baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 26.0F);; f = baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 30.0F))
    {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextSize(f);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.invalidate();
      return;
      i = baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 41.0F);
      break;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bivi = ((bivi)bijo.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, bjnf.a()).a(bivi.class));
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
  
  public ArrayList<bitb> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new bitb((String)localIterator.next()));
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
    if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) && (this.jdField_a_of_type_Bitq != null)) {
      this.jdField_a_of_type_Bitq.a();
    }
    b(paramString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839707);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextColor(paramString2);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramString3);
    a(paramString1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setStroke(paramBoolean1);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadow(paramBoolean2);
  }
  
  public void b()
  {
    Log.d("AEGIFTextMvp", "On loading completed...");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_Bitq = new bitq(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this);
    this.jdField_a_of_type_Bitq.setHasStableIds(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bitq);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setClipToPadding(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setClipChildren(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new bitg(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bith(this));
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(paramString);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 4.0F));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    AEGIFOutlineTextView localAEGIFOutlineTextView = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
    float f;
    if (paramString.indexOf('\n') > 0)
    {
      f = baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 26.0F);
      localAEGIFOutlineTextView.setTextSize(f);
      if (paramString.indexOf('\n') <= 0) {
        break label114;
      }
    }
    label114:
    for (int i = baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 73.199997F);; i = baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 41.0F))
    {
      localLayoutParams.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(localLayoutParams);
      return;
      f = baxn.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 30.0F);
      break;
    }
  }
  
  public void c()
  {
    Log.d("AEGIFTextMvp", "On loading...");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    d();
    this.jdField_a_of_type_Bivi.a().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new biti(this));
  }
  
  public void d()
  {
    Log.d("AEGIFTextMvp", "Clearing smart text");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839708);
    if (this.jdField_a_of_type_Bitq != null) {
      this.jdField_a_of_type_Bitq.a();
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    a(false, true);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
    b(ajya.a(2131700001), "#ccffffff", "#000000");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitf
 * JD-Core Version:    0.7.0.1
 */