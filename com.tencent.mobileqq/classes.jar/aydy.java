import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aydy
  extends bfwn
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<ayea> jdField_a_of_type_JavaUtilList;
  Map<String, ayea> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public aydy(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener, List<ayea> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public String a(String paramString)
  {
    Object localObject = (ayea)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null) {
      return paramString;
    }
    localObject = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ayea)localObject).jdField_a_of_type_JavaLangString, ((ayea)localObject).b, ((ayea)localObject).jdField_a_of_type_Int);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ((ayea)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = ((String)localObject);
    }
    return ((ayea)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ayea paramayea)
  {
    if (paramayea == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramayea);
    this.jdField_a_of_type_JavaUtilMap.put(paramayea.jdField_a_of_type_JavaLangString, paramayea);
  }
  
  public void a(String paramString)
  {
    ayea localayea = (ayea)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localayea == null) {
      return;
    }
    localayea.c = a(paramString);
    notifyDataSetChanged();
  }
  
  public void b(String paramString)
  {
    paramString = (ayea)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
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
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label110:
    ayea localayea;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562490, null);
      paramViewGroup = new aydz(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367482));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370809));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131376452));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362807));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_Int != 2) {
        break label230;
      }
      paramViewGroup.b.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localayea = (ayea)getItem(paramInt);
      String str = String.valueOf(localayea.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint64_uin.get());
      baxt localbaxt = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localbaxt);
      str = a(str);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramInt = localayea.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.get();
      if (paramInt != 1) {
        break label249;
      }
      paramViewGroup.b.setText(2131720090);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = localayea.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo;
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramViewGroup = (aydz)paramView.getTag();
      break;
      label230:
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break label110;
      label249:
      if (paramInt == 2) {
        paramViewGroup.b.setText(2131720091);
      } else {
        paramViewGroup.b.setText(ajyc.a(2131714778));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aydy
 * JD-Core Version:    0.7.0.1
 */