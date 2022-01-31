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

public class axwb
  extends axun
{
  private String S = "";
  public ArrayList<axun> a;
  
  public axwb()
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
    paramContext.setId(2131362311);
    if (AppSetting.d) {
      paramContext.setContentDescription(this.S);
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
          ((axun)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramContext, ((LinearLayout)localObject).getChildAt(i), null);
          i += 1;
        }
      }
    }
    else
    {
      paramView = a(paramContext);
      paramView.setPadding(actn.a(12.0F, (Resources)localObject), 0, actn.a(12.0F, (Resources)localObject), 0);
      i = 0;
      int j = 1;
      paramBundle = paramView;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramBundle = ((axun)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramContext, null, null);
        if (j == 0)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          localLayoutParams.setMargins(actn.a(2.0F, (Resources)localObject), 0, 0, 0);
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
  
  public void a(axun paramaxun)
  {
    if ((paramaxun instanceof axwa)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramaxun);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    int j = paramObjectInput.readInt();
    int i = 0;
    while (i < j)
    {
      axun localaxun = axux.a(paramObjectInput.readUTF());
      if (localaxun != null)
      {
        localaxun.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        localaxun.a(paramObjectInput);
        a(localaxun);
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
      ((axun)localIterator.next()).a(paramObjectOutput);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((axun)localIterator.next()).a(paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(axwe paramaxwe)
  {
    if (paramaxwe == null) {
      return true;
    }
    int j = paramaxwe.a();
    int i = 0;
    label13:
    axwe localaxwe;
    if (i < j)
    {
      localaxwe = paramaxwe.a(i);
      if (localaxwe != null) {
        break label37;
      }
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label37:
      axun localaxun = null;
      if ("tag".equals(localaxwe.b)) {
        localaxun = axux.a(localaxwe.b);
      }
      if (localaxun == null) {
        return false;
      }
      if (!localaxun.a(localaxwe)) {
        break label89;
      }
      a(localaxun);
    }
    label89:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwb
 * JD-Core Version:    0.7.0.1
 */