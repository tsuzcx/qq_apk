import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import java.util.ArrayList;
import java.util.List;

public class amng
  extends amnk
{
  public int a;
  
  public int a()
  {
    return 1;
  }
  
  public View a()
  {
    switch (this.b)
    {
    case 1: 
    default: 
      return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.c, this.f, this.jdField_a_of_type_Int);
    case 0: 
      return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.c, this.f, this.jdField_a_of_type_Int);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558677, null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(View paramView, int paramInt)
  {
    for (;;)
    {
      int j;
      int i;
      int k;
      try
      {
        Object localObject;
        amlw localamlw;
        int i1;
        if (this.b == 0)
        {
          int m = this.f;
          int n = this.jdField_a_of_type_Int;
          j = 0;
          i = 0;
          if (j < this.jdField_a_of_type_Int)
          {
            LinearLayout localLinearLayout = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(j);
            k = 0;
            if (k >= this.f) {
              break label266;
            }
            localObject = localLinearLayout.getChildAt(k);
            localamlw = (amlw)((View)localObject).getTag();
            i1 = m * n * paramInt + i;
            List localList = this.jdField_a_of_type_JavaUtilList;
            if (localList != null) {
              continue;
            }
          }
        }
        return;
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = ((amlu)this.jdField_a_of_type_JavaUtilList.get(i1)).a;
          localamlw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localamlw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((amlu)this.jdField_a_of_type_JavaUtilList.get(i1)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
          if ((localObject != null) && (((ApolloActionData)localObject).actionName != null)) {
            localamlw.jdField_a_of_type_AndroidWidgetTextView.setText(((ApolloActionData)localObject).actionName);
          }
          localamlw.jdField_a_of_type_Amlu = ((amlu)this.jdField_a_of_type_JavaUtilList.get(i1));
          localamlw.jdField_a_of_type_Amlu.c = 1;
        }
        else
        {
          ((View)localObject).setContentDescription(null);
          ((View)localObject).setOnClickListener(null);
        }
      }
      finally {}
      label266:
      j += 1;
      continue;
      k += 1;
      i += 1;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool;
    if (paramQQAppInterface == null) {
      bool = false;
    }
    Object localObject1;
    label50:
    int i;
    for (;;)
    {
      return bool;
      try
      {
        localObject1 = (amkj)paramQQAppInterface.getManager(154);
        if (localObject1 == null)
        {
          bool = false;
        }
        else
        {
          if (paramSessionInfo.curType == 0) {}
          for (paramSessionInfo = ((amkj)localObject1).jdField_a_of_type_JavaUtilList;; paramSessionInfo = ((amkj)localObject1).b)
          {
            if (paramSessionInfo == null) {
              break label250;
            }
            if (paramSessionInfo.size() != 0) {
              break;
            }
            break label250;
            if ((paramSessionInfo.curType != 1) && (paramSessionInfo.curType != 3000)) {
              break label245;
            }
          }
          if (this.jdField_a_of_type_JavaUtilList != null) {
            this.jdField_a_of_type_JavaUtilList.clear();
          }
          for (;;)
          {
            i = paramSessionInfo.size() - 1;
            break;
            this.jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          localObject1 = new ApolloActionData();
        }
      }
      finally {}
    }
    label140:
    Object localObject2 = (amir)paramQQAppInterface.getManager(155);
    if (localObject2 != null)
    {
      localObject2 = ((amir)localObject2).a(((ApolloActionRecentData)paramSessionInfo.get(i)).actionId);
      localObject1 = localObject2;
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject2 = new amlx(paramQQAppInterface.getCurrentUin());
      ((amlx)localObject2).a = ((ApolloActionData)localObject1);
      ((amlx)localObject2).c = 1;
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
      label275:
      for (;;)
      {
        bool = true;
        break;
        label245:
        paramSessionInfo = null;
        break label50;
        label250:
        bool = false;
        break;
        for (;;)
        {
          if (i < 0) {
            break label275;
          }
          if (paramQQAppInterface != null) {
            break label140;
          }
          bool = false;
          break;
          i -= 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amng
 * JD-Core Version:    0.7.0.1
 */