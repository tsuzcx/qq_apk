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

public class awvz
  extends awul
{
  private String S = "";
  public ArrayList<awul> a;
  
  public awvz()
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
    paramContext.setId(2131296770);
    if (AppSetting.c) {
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
          ((awul)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramContext, ((LinearLayout)localObject).getChildAt(i), null);
          i += 1;
        }
      }
    }
    else
    {
      paramView = a(paramContext);
      paramView.setPadding(aciy.a(12.0F, (Resources)localObject), 0, aciy.a(12.0F, (Resources)localObject), 0);
      i = 0;
      int j = 1;
      paramBundle = paramView;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramBundle = ((awul)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramContext, null, null);
        if (j == 0)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          localLayoutParams.setMargins(aciy.a(2.0F, (Resources)localObject), 0, 0, 0);
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
  
  public void a(awul paramawul)
  {
    if ((paramawul instanceof awvy)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramawul);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    int j = paramObjectInput.readInt();
    int i = 0;
    while (i < j)
    {
      awul localawul = awuv.a(paramObjectInput.readUTF());
      if (localawul != null)
      {
        localawul.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        localawul.a(paramObjectInput);
        a(localawul);
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
      ((awul)localIterator.next()).a(paramObjectOutput);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((awul)localIterator.next()).a(paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(awwc paramawwc)
  {
    if (paramawwc == null) {
      return true;
    }
    int j = paramawwc.a();
    int i = 0;
    label13:
    awwc localawwc;
    if (i < j)
    {
      localawwc = paramawwc.a(i);
      if (localawwc != null) {
        break label37;
      }
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label37:
      awul localawul = null;
      if ("tag".equals(localawwc.b)) {
        localawul = awuv.a(localawwc.b);
      }
      if (localawul == null) {
        return false;
      }
      if (!localawul.a(localawwc)) {
        break label89;
      }
      a(localawul);
    }
    label89:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awvz
 * JD-Core Version:    0.7.0.1
 */