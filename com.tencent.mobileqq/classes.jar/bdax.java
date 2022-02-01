import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public class bdax
  extends bcvs
{
  public final ArrayList<bcvs> a;
  public boolean a;
  public int o = afur.a(2.5F, BaseApplicationImpl.getContext().getResources());
  public int p = this.o;
  private int q;
  
  public bdax()
  {
    this.jdField_a_of_type_JavaLangString = "tr";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    label30:
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      int i;
      bdar localbdar;
      View localView;
      int j;
      if ((paramView != null) && ((paramView instanceof ViewGroup)))
      {
        paramView = (ViewGroup)paramView;
        paramView.removeAllViews();
        i = 0;
        localObject = paramView;
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label195;
        }
        localObject = (bcvs)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localObject instanceof bdar))
        {
          localbdar = (bdar)localObject;
          localView = localbdar.a(paramContext, null, paramBundle);
          if ((localView instanceof TextView))
          {
            if (localbdar.r != 0) {
              break label167;
            }
            j = 1;
            label103:
            if (this.q == 1) {
              break label177;
            }
          }
        }
      }
      label167:
      label177:
      for (localObject = new LinearLayout.LayoutParams(0, -1, j);; localObject = new LinearLayout.LayoutParams(-2, -1))
      {
        ((TextView)localView).setGravity(localbdar.p);
        paramView.addView(localView, (ViewGroup.LayoutParams)localObject);
        i += 1;
        break label30;
        paramView = new LinearLayout(paramContext);
        break;
        j = localbdar.r;
        break label103;
      }
    }
    else
    {
      localObject = null;
    }
    label195:
    return localObject;
  }
  
  public String a()
  {
    return "tr";
  }
  
  void a(bcvs parambcvs)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambcvs);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.q = paramObjectInput.readInt();
    this.o = paramObjectInput.readInt();
    this.p = paramObjectInput.readInt();
    int j = paramObjectInput.readInt();
    Object localObject = paramObjectInput.readUTF();
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("true"))) {
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    while (i < j)
    {
      localObject = paramObjectInput.readUTF();
      if ("td".equals(localObject))
      {
        localObject = bcwc.a((String)localObject);
        if (localObject != null)
        {
          ((bcvs)localObject).a(paramObjectInput);
          a((bcvs)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.q);
    paramObjectOutput.writeInt(this.o);
    paramObjectOutput.writeInt(this.p);
    paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "true";; localObject = "false")
    {
      paramObjectOutput.writeUTF((String)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bcvs)((Iterator)localObject).next()).a(paramObjectOutput);
      }
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "tr");
    paramXmlSerializer.endTag(null, "tr");
  }
  
  public boolean a(bcxj parambcxj)
  {
    boolean bool2 = false;
    Object localObject1 = parambcxj.a("mode");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    boolean bool1;
    try
    {
      this.q = Integer.valueOf((String)localObject1).intValue();
      localObject1 = parambcxj.a("margin");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        if ((localObject1 == null) || (localObject1.length < 2)) {}
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        do
        {
          Object localObject2 = BaseApplicationImpl.getContext().getResources();
          this.o = afur.a(Float.valueOf(localObject1[0]).floatValue(), (Resources)localObject2);
          this.p = afur.a(Float.valueOf(localObject1[1]).floatValue(), (Resources)localObject2);
          localObject1 = parambcxj.a("hidden");
          if ((localObject1 != null) && (((String)localObject1).toLowerCase().equals("true"))) {
            this.jdField_a_of_type_Boolean = true;
          }
          int i = 0;
          while (i < parambcxj.a())
          {
            localObject1 = parambcxj.a(i);
            if ((localObject1 != null) && ("td".equals(((bcxj)localObject1).b)))
            {
              localObject2 = bcwc.a(((bcxj)localObject1).b);
              bool1 = bool2;
              if (localObject2 == null) {
                return bool1;
              }
              bool1 = bool2;
              if (!((bcvs)localObject2).a((bcxj)localObject1)) {
                return bool1;
              }
              a((bcvs)localObject2);
            }
            i += 1;
          }
          localNumberFormatException1 = localNumberFormatException1;
        } while (!QLog.isColorLevel());
        QLog.w("StructMsgItemTr", 2, "mode must be a numeric ", localNumberFormatException1);
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("StructMsgItemTr", 2, "h must be a numeric ", localNumberFormatException2);
          }
          this.o = 0;
          this.p = 0;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdax
 * JD-Core Version:    0.7.0.1
 */