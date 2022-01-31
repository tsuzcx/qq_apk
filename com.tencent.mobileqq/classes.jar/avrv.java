import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import java.util.ArrayList;
import java.util.List;

public class avrv
  extends BaseAdapter
  implements bdbc
{
  private Context jdField_a_of_type_AndroidContentContext;
  private avqr jdField_a_of_type_Avqr;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private List<avsg> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public avrv(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Avqr = new avqr(paramQQAppInterface, paramContext);
    }
  }
  
  public List<avsg> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
  }
  
  public void a(List<avsg> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void b(List<avsg> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_Avqr == null) {
      return -1;
    }
    return this.jdField_a_of_type_Avqr.a((avsg)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Avqr == null) {
      paramViewGroup = null;
    }
    avsg localavsg;
    avqc localavqc;
    do
    {
      return paramViewGroup;
      localavsg = (avsg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramInt = this.jdField_a_of_type_Avqr.a(localavsg);
      localavqc = this.jdField_a_of_type_Avqr.a(paramInt);
      paramViewGroup = paramView;
    } while (localavqc == null);
    localavqc.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    return localavqc.a(localavsg, this.jdField_a_of_type_AndroidContentContext, paramView);
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Avqr == null) {
      return 1;
    }
    return this.jdField_a_of_type_Avqr.a();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
      return;
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avrv
 * JD-Core Version:    0.7.0.1
 */