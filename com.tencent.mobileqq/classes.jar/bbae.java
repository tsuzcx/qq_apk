import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bbae
  extends RecyclerView.Adapter<bbah>
  implements aoog
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new bbaf(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private aoof jdField_a_of_type_Aoof;
  private List<ReceiptMessageReadMemberListFragment.MemberInfo> jdField_a_of_type_JavaUtilList;
  private Map<String, Bitmap> jdField_a_of_type_JavaUtilMap;
  
  private bbae(Context paramContext, aoof paramaoof, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aoof = paramaoof;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.a();
    this.jdField_a_of_type_Aoof.a(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    paramRecyclerView.setOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
  }
  
  private Bitmap a(String paramString)
  {
    return a(paramString, 1, (byte)0);
  }
  
  private Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Aoof.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aoof.a()) {
      this.jdField_a_of_type_Aoof.a(paramString, paramInt, true, paramByte);
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  private void a()
  {
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i);
      localObject = (bbah)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
      Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(bbah.a((bbah)localObject));
      if (localBitmap != null) {
        bbah.a((bbah)localObject).setImageBitmap(localBitmap);
      }
      i += 1;
    }
  }
  
  public bbah a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bbah(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562808, paramViewGroup, false), null);
  }
  
  public void a(bbah parambbah, int paramInt)
  {
    ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    bbah.a(parambbah, localMemberInfo.a);
    bbah.a(parambbah).setText(localMemberInfo.b);
    bbah.a(parambbah).setImageBitmap(a(localMemberInfo.a));
    EventCollector.getInstance().onRecyclerBindViewHolder(parambbah, paramInt, getItemId(paramInt));
  }
  
  public void a(List<ReceiptMessageReadMemberListFragment.MemberInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramBitmap);
    if (paramInt1 <= 0)
    {
      if (this.jdField_a_of_type_Int == 0) {
        a();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbae
 * JD-Core Version:    0.7.0.1
 */