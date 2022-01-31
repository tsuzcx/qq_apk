import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class awwi
  extends awun
{
  View.OnClickListener a;
  public String ai;
  public String aj;
  public String ak;
  public String al;
  long c;
  public int i = 999;
  
  public awwi()
  {
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new awwl(this);
    this.jdField_a_of_type_JavaLangString = "button";
  }
  
  private void b()
  {
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.equals("pay"))) {
      if (!TextUtils.isEmpty(this.e)) {
        break label130;
      }
    }
    for (Object localObject = this.d;; localObject = this.e)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("appId")) {
          this.ai = ((JSONObject)localObject).getString("appId");
        }
        if (((JSONObject)localObject).has("orderId")) {
          this.aj = ((JSONObject)localObject).getString("orderId");
        }
        if (((JSONObject)localObject).has("package")) {
          this.al = ((JSONObject)localObject).getString("package");
        }
        if (((JSONObject)localObject).has("expireTime")) {
          this.ak = ((JSONObject)localObject).getString("expireTime");
        }
        return;
      }
      catch (Exception localException)
      {
        label130:
        while (!QLog.isColorLevel()) {}
        QLog.e("StructMsgItemButton", 2, "read msg=" + localException.getMessage());
      }
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    int j = paramBundle.getInt("Layout3ButtonCount", 0);
    int k = paramBundle.getInt("Layout3ButtonIndex", -1);
    paramContext = (TextView)super.a(paramContext, paramView, paramBundle);
    paramContext.setBackgroundResource(2130838124);
    if (j > 1) {
      if (k == 0)
      {
        paramContext.setBackgroundResource(2130838117);
        j = 0;
      }
    }
    for (;;)
    {
      paramContext.setTag(2131310759, Integer.valueOf(j));
      paramContext.setGravity(17);
      paramContext.setSingleLine();
      paramContext.setEllipsize(null);
      if ((!b()) || ((b()) && (a())))
      {
        paramContext.setClickable(true);
        paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramContext.setOnLongClickListener(new awwj(this));
        paramContext.setOnTouchListener(new awwk(this));
        return paramContext;
        if (k == j - 1)
        {
          paramContext.setBackgroundResource(2130838121);
          j = 2;
        }
        else
        {
          paramContext.setBackgroundResource(2130838119);
          j = 1;
        }
      }
      else
      {
        paramContext.setClickable(false);
        paramContext.setOnClickListener(null);
        paramContext.setOnTouchListener(null);
        paramContext.setOnLongClickListener(null);
        return paramContext;
        j = 0;
      }
    }
  }
  
  public String a()
  {
    return "Confirm";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.b = paramObjectInput.readUTF();
    this.jdField_c_of_type_JavaLangString = paramObjectInput.readUTF();
    this.d = paramObjectInput.readUTF();
    this.e = paramObjectInput.readUTF();
    this.f = paramObjectInput.readUTF();
    if (this.jdField_a_of_type_Int > 5)
    {
      this.j = paramObjectInput.readUTF();
      this.k = paramObjectInput.readUTF();
      this.l = paramObjectInput.readUTF();
    }
    b();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.b == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label158;
      }
      str = "";
      label32:
      paramObjectOutput.writeUTF(str);
      if (this.d != null) {
        break label166;
      }
      str = "";
      label49:
      paramObjectOutput.writeUTF(str);
      if (this.e != null) {
        break label174;
      }
      str = "";
      label66:
      paramObjectOutput.writeUTF(str);
      if (this.f != null) {
        break label182;
      }
      str = "";
      label83:
      paramObjectOutput.writeUTF(str);
      if (this.jdField_a_of_type_Int > 5)
      {
        if (this.j != null) {
          break label190;
        }
        str = "";
        label108:
        paramObjectOutput.writeUTF(str);
        if (this.k != null) {
          break label198;
        }
        str = "";
        label125:
        paramObjectOutput.writeUTF(str);
        if (this.l != null) {
          break label206;
        }
      }
    }
    label158:
    label166:
    label174:
    label182:
    label190:
    label198:
    label206:
    for (String str = "";; str = this.l)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.b;
      break;
      str = this.jdField_c_of_type_JavaLangString;
      break label32;
      str = this.d;
      break label49;
      str = this.e;
      break label66;
      str = this.f;
      break label83;
      str = this.j;
      break label108;
      str = this.k;
      break label125;
    }
  }
  
  public void a(String paramString, MessageRecord paramMessageRecord, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    int k = 999;
    int j = k;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      j = Integer.valueOf(paramString).intValue();
      if ((j != 23001027) && (j != 0) && (j != -4) && (j != -6))
      {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (!((agmq)paramString.getManager(245)).a(paramMessageRecord.frienduin))
        {
          k = 1;
          j = -4;
          if (k != 0) {
            paramStructMsgForGeneralShare.savePayInfo(paramString.getApplication(), this.aj, j);
          }
          b(j);
          return;
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        j = k;
        continue;
        if (c())
        {
          k = 1;
          j = -6;
        }
        else
        {
          k = 0;
        }
      }
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    super.a(paramXmlSerializer);
    paramXmlSerializer.startTag(null, "button");
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "action", this.jdField_c_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.d)) {
      paramXmlSerializer.attribute(null, "actionData", this.d);
    }
    if (!TextUtils.isEmpty(this.e)) {
      paramXmlSerializer.attribute(null, "a_actionData", this.e);
    }
    if (!TextUtils.isEmpty(this.f)) {
      paramXmlSerializer.attribute(null, "i_actionData", this.f);
    }
    if (!TextUtils.isEmpty(this.b)) {
      paramXmlSerializer.attribute(null, "url", this.b);
    }
    if (!TextUtils.isEmpty(this.j)) {
      paramXmlSerializer.attribute(null, "index", this.j);
    }
    if (!TextUtils.isEmpty(this.k)) {
      paramXmlSerializer.attribute(null, "index_name", this.k);
    }
    if (!TextUtils.isEmpty(this.l)) {
      paramXmlSerializer.attribute(null, "index_type", this.l);
    }
    paramXmlSerializer.endTag(null, "button");
  }
  
  public boolean a()
  {
    switch (this.i)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public boolean a(awwc paramawwc)
  {
    super.a(paramawwc);
    this.jdField_c_of_type_JavaLangString = paramawwc.a("action");
    this.d = paramawwc.a("actionData");
    this.e = paramawwc.a("a_actionData");
    this.f = paramawwc.a("i_actionData");
    this.b = paramawwc.a("url");
    this.j = paramawwc.a("index");
    this.k = paramawwc.a("index_name");
    this.l = paramawwc.a("index_type");
    b();
    return true;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
    switch (paramInt)
    {
    case -3: 
    case -2: 
    case -1: 
    default: 
      return;
    case 23001027: 
      this.i = 0;
    case 0: 
      a(ajjy.a(2131648820));
      b("#ff777777");
      return;
    case -4: 
      a(ajjy.a(2131648827));
      b("#ff777777");
      return;
    }
    a(ajjy.a(2131648818));
    b("#ff777777");
  }
  
  public boolean b()
  {
    return (!TextUtils.isEmpty(this.ai)) && (!TextUtils.isEmpty(this.ak)) && (!TextUtils.isEmpty(this.aj)) && ("pay".equals(this.jdField_c_of_type_JavaLangString));
  }
  
  protected int c()
  {
    return 2131297958;
  }
  
  public boolean c()
  {
    long l1 = NetConnInfoCenter.getServerTime();
    try
    {
      long l2 = Long.parseLong(this.ak);
      if (l2 > l1) {
        return false;
      }
    }
    catch (Exception localException) {}
    return true;
  }
  
  public int e()
  {
    return -16734752;
  }
  
  public int f()
  {
    return 32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awwi
 * JD-Core Version:    0.7.0.1
 */