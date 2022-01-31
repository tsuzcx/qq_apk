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

public class bagg
  extends bici
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<bagi> jdField_a_of_type_JavaUtilList;
  Map<String, bagi> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public bagg(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener, List<bagi> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public String a(String paramString)
  {
    Object localObject = (bagi)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null) {
      return paramString;
    }
    localObject = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((bagi)localObject).jdField_a_of_type_JavaLangString, ((bagi)localObject).b, ((bagi)localObject).jdField_a_of_type_Int);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ((bagi)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = ((String)localObject);
    }
    return ((bagi)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bagi parambagi)
  {
    if (parambagi == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(0, parambagi);
    this.jdField_a_of_type_JavaUtilMap.put(parambagi.jdField_a_of_type_JavaLangString, parambagi);
  }
  
  public void a(String paramString)
  {
    bagi localbagi = (bagi)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localbagi == null) {
      return;
    }
    localbagi.c = a(paramString);
    notifyDataSetChanged();
  }
  
  public void b(String paramString)
  {
    paramString = (bagi)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
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
    bagi localbagi;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562711, null);
      paramViewGroup = new bagh(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367620));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371139));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131377008));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362838));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_Int != 2) {
        break label230;
      }
      paramViewGroup.b.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localbagi = (bagi)getItem(paramInt);
      String str = String.valueOf(localbagi.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint64_uin.get());
      bdbk localbdbk = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localbdbk);
      str = a(str);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramInt = localbagi.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.get();
      if (paramInt != 1) {
        break label249;
      }
      paramViewGroup.b.setText(2131720649);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = localbagi.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo;
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramViewGroup = (bagh)paramView.getTag();
      break;
      label230:
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break label110;
      label249:
      if (paramInt == 2) {
        paramViewGroup.b.setText(2131720650);
      } else {
        paramViewGroup.b.setText(alud.a(2131715173));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagg
 * JD-Core Version:    0.7.0.1
 */