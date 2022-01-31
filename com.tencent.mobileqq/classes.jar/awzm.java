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

public class awzm
  extends awul
{
  public final ArrayList<awul> a;
  public boolean a;
  public int i = aciy.a(2.5F, BaseApplicationImpl.getContext().getResources());
  public int j = this.i;
  private int k;
  
  public awzm()
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
      int m;
      awzg localawzg;
      View localView;
      int n;
      if ((paramView != null) && ((paramView instanceof ViewGroup)))
      {
        paramView = (ViewGroup)paramView;
        paramView.removeAllViews();
        m = 0;
        localObject = paramView;
        if (m >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label195;
        }
        localObject = (awul)this.jdField_a_of_type_JavaUtilArrayList.get(m);
        if ((localObject instanceof awzg))
        {
          localawzg = (awzg)localObject;
          localView = localawzg.a(paramContext, null, paramBundle);
          if ((localView instanceof TextView))
          {
            if (localawzg.l != 0) {
              break label167;
            }
            n = 1;
            label103:
            if (this.k == 1) {
              break label177;
            }
          }
        }
      }
      label167:
      label177:
      for (localObject = new LinearLayout.LayoutParams(0, -1, n);; localObject = new LinearLayout.LayoutParams(-2, -1))
      {
        ((TextView)localView).setGravity(localawzg.j);
        paramView.addView(localView, (ViewGroup.LayoutParams)localObject);
        m += 1;
        break label30;
        paramView = new LinearLayout(paramContext);
        break;
        n = localawzg.l;
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
  
  void a(awul paramawul)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramawul);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.k = paramObjectInput.readInt();
    this.i = paramObjectInput.readInt();
    this.j = paramObjectInput.readInt();
    int n = paramObjectInput.readInt();
    Object localObject = paramObjectInput.readUTF();
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("true"))) {
      this.jdField_a_of_type_Boolean = true;
    }
    int m = 0;
    while (m < n)
    {
      localObject = paramObjectInput.readUTF();
      if ("td".equals(localObject))
      {
        localObject = awuv.a((String)localObject);
        if (localObject != null)
        {
          ((awul)localObject).a(paramObjectInput);
          a((awul)localObject);
        }
      }
      m += 1;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    paramObjectOutput.writeInt(this.k);
    paramObjectOutput.writeInt(this.i);
    paramObjectOutput.writeInt(this.j);
    paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "true";; localObject = "false")
    {
      paramObjectOutput.writeUTF((String)localObject);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((awul)((Iterator)localObject).next()).a(paramObjectOutput);
      }
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "tr");
    paramXmlSerializer.endTag(null, "tr");
  }
  
  public boolean a(awwc paramawwc)
  {
    boolean bool2 = false;
    Object localObject1 = paramawwc.a("mode");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    boolean bool1;
    try
    {
      this.k = Integer.valueOf((String)localObject1).intValue();
      localObject1 = paramawwc.a("margin");
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
          this.i = aciy.a(Float.valueOf(localObject1[0]).floatValue(), (Resources)localObject2);
          this.j = aciy.a(Float.valueOf(localObject1[1]).floatValue(), (Resources)localObject2);
          localObject1 = paramawwc.a("hidden");
          if ((localObject1 != null) && (((String)localObject1).toLowerCase().equals("true"))) {
            this.jdField_a_of_type_Boolean = true;
          }
          int m = 0;
          while (m < paramawwc.a())
          {
            localObject1 = paramawwc.a(m);
            if ((localObject1 != null) && ("td".equals(((awwc)localObject1).b)))
            {
              localObject2 = awuv.a(((awwc)localObject1).b);
              bool1 = bool2;
              if (localObject2 == null) {
                return bool1;
              }
              bool1 = bool2;
              if (!((awul)localObject2).a((awwc)localObject1)) {
                return bool1;
              }
              a((awul)localObject2);
            }
            m += 1;
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
          this.i = 0;
          this.j = 0;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awzm
 * JD-Core Version:    0.7.0.1
 */