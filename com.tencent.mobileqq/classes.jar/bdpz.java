import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public class bdpz
  extends bdol
{
  public ArrayList<bdol> a;
  private String ac = "";
  
  public bdpz()
  {
    this.jdField_a_of_type_JavaLangString = "taglist";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.setOrientation(0);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setId(2131362422);
    if (AppSetting.c) {
      paramContext.setContentDescription(this.ac);
    }
    return paramContext;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = paramContext.getResources();
    int i;
    if (paramView != null)
    {
      paramBundle = paramView;
      if ((paramView instanceof LinearLayout))
      {
        localObject = (LinearLayout)paramView;
        i = 0;
        for (;;)
        {
          paramBundle = paramView;
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          ((bdol)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramContext, ((LinearLayout)localObject).getChildAt(i), null);
          i += 1;
        }
      }
    }
    else
    {
      paramView = a(paramContext);
      paramView.setPadding(agej.a(12.0F, (Resources)localObject), 0, agej.a(12.0F, (Resources)localObject), 0);
      i = 0;
      int j = 1;
      paramBundle = paramView;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramBundle = ((bdol)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramContext, null, null);
        if (j == 0)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          localLayoutParams.setMargins(agej.a(2.0F, (Resources)localObject), 0, 0, 0);
          paramView.addView(paramBundle, localLayoutParams);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView.addView(paramBundle);
          j = 0;
        }
      }
    }
    return paramBundle;
  }
  
  public String a()
  {
    return "taglist";
  }
  
  public void a(bdol parambdol)
  {
    if ((parambdol instanceof bdpy)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambdol);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    int j = paramObjectInput.readInt();
    int i = 0;
    while (i < j)
    {
      bdol localbdol = bdov.a(paramObjectInput.readUTF());
      if (localbdol != null)
      {
        localbdol.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        localbdol.a(paramObjectInput);
        a(localbdol);
      }
      i += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bdol)localIterator.next()).a(paramObjectOutput);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bdol)localIterator.next()).a(paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(bdqc parambdqc)
  {
    if (parambdqc == null) {
      return true;
    }
    int j = parambdqc.a();
    int i = 0;
    label13:
    bdqc localbdqc;
    if (i < j)
    {
      localbdqc = parambdqc.a(i);
      if (localbdqc != null) {
        break label37;
      }
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label37:
      bdol localbdol = null;
      if ("tag".equals(localbdqc.b)) {
        localbdol = bdov.a(localbdqc.b);
      }
      if (localbdol == null) {
        return false;
      }
      if (!localbdol.a(localbdqc)) {
        break label89;
      }
      a(localbdol);
    }
    label89:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpz
 * JD-Core Version:    0.7.0.1
 */