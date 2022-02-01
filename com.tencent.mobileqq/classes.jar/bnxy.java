import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.videoshelf.model.edit.ShelfNode;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bnxy
  extends RecyclerView.Adapter<bnyb>
{
  private static long jdField_a_of_type_Long;
  private static final String jdField_a_of_type_JavaLangString = bnxy.class.getSimpleName();
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bnya jdField_a_of_type_Bnya;
  private HashMap<Integer, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<ShelfNode> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private int c;
  
  public bnxy(Context paramContext, List<ShelfNode> paramList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    if (this.c != 0)
    {
      this.jdField_a_of_type_Double = (this.jdField_b_of_type_Int / this.c);
      if (this.jdField_a_of_type_Double < 1.0D) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long >= 200L) {
      bool = true;
    }
    jdField_a_of_type_Long = l;
    return bool;
  }
  
  public bnyb a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new bnyb(this, LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558498, paramViewGroup, false));
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      if (BitmapUtils.isLegal(paramBitmap)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramBitmap);
      }
    }
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
        localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      } while (!BitmapUtils.isLegal(paramBitmap));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramBitmap);
    } while ((!BitmapUtils.isLegal(localBitmap)) || (localBitmap == paramBitmap));
    localBitmap.recycle();
  }
  
  public void a(bnya parambnya)
  {
    this.jdField_a_of_type_Bnya = parambnya;
  }
  
  @TargetApi(21)
  public void a(@NonNull bnyb parambnyb, int paramInt)
  {
    Object localObject = (ShelfNode)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null)
    {
      Log.e(jdField_a_of_type_JavaLangString, "onBindViewHolder contain null data item");
      EventCollector.getInstance().onRecyclerBindViewHolder(parambnyb, paramInt, getItemId(paramInt));
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = BitmapUtils.decodeSampleBitmap(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString + File.separator + ((ShelfNode)localObject).getCoverUri(), 1);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject);
    }
    parambnyb.c.setImageBitmap((Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    localObject = "0" + (paramInt + 1);
    parambnyb.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    parambnyb.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == paramInt)
    {
      parambnyb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      parambnyb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      parambnyb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambnyb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      parambnyb.itemView.setOnClickListener(new bnxz(this, paramInt));
      break;
      parambnyb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      parambnyb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      parambnyb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      parambnyb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxy
 * JD-Core Version:    0.7.0.1
 */