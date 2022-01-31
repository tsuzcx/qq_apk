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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aups
  extends RecyclerView.Adapter<aupv>
  implements azwh
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new aupt(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private azwg jdField_a_of_type_Azwg;
  private List<ReceiptMessageReadMemberListFragment.MemberInfo> jdField_a_of_type_JavaUtilList;
  private Map<String, Bitmap> jdField_a_of_type_JavaUtilMap;
  
  private aups(Context paramContext, azwg paramazwg, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Azwg = paramazwg;
    this.jdField_a_of_type_AndroidGraphicsBitmap = bacm.a();
    this.jdField_a_of_type_Azwg.a(this);
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
    Bitmap localBitmap = this.jdField_a_of_type_Azwg.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Azwg.a()) {
      this.jdField_a_of_type_Azwg.a(paramString, paramInt, true, paramByte);
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
      localObject = (aupv)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
      Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(aupv.a((aupv)localObject));
      if (localBitmap != null) {
        aupv.a((aupv)localObject).setImageBitmap(localBitmap);
      }
      i += 1;
    }
  }
  
  public aupv a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aupv(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131496714, paramViewGroup, false), null);
  }
  
  public void a(aupv paramaupv, int paramInt)
  {
    ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    aupv.a(paramaupv, localMemberInfo.a);
    aupv.a(paramaupv).setText(localMemberInfo.b);
    aupv.a(paramaupv).setImageBitmap(a(localMemberInfo.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aups
 * JD-Core Version:    0.7.0.1
 */