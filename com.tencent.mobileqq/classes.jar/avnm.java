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

public class avnm
  extends BaseAdapter
  implements bcwt
{
  private Context jdField_a_of_type_AndroidContentContext;
  private avmi jdField_a_of_type_Avmi;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private List<avnx> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public avnm(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Avmi = new avmi(paramQQAppInterface, paramContext);
    }
  }
  
  public List<avnx> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
  }
  
  public void a(List<avnx> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void b(List<avnx> paramList)
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
    if (this.jdField_a_of_type_Avmi == null) {
      return -1;
    }
    return this.jdField_a_of_type_Avmi.a((avnx)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Avmi == null) {
      paramViewGroup = null;
    }
    avnx localavnx;
    avlt localavlt;
    do
    {
      return paramViewGroup;
      localavnx = (avnx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramInt = this.jdField_a_of_type_Avmi.a(localavnx);
      localavlt = this.jdField_a_of_type_Avmi.a(paramInt);
      paramViewGroup = paramView;
    } while (localavlt == null);
    localavlt.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    return localavlt.a(localavnx, this.jdField_a_of_type_AndroidContentContext, paramView);
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Avmi == null) {
      return 1;
    }
    return this.jdField_a_of_type_Avmi.a();
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
 * Qualified Name:     avnm
 * JD-Core Version:    0.7.0.1
 */