import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public abstract class axuo
  extends axun
{
  public ArrayList<axun> a;
  public int k;
  protected int l;
  protected int m;
  public int n;
  
  protected axuo()
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_n_of_type_Int = b();
  }
  
  protected axuo(Collection<axun> paramCollection)
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramCollection);
    this.jdField_n_of_type_Int = b();
  }
  
  private boolean b()
  {
    return (this.jdField_l_of_type_Int >= 0) && (this.jdField_l_of_type_Int <= 3);
  }
  
  public int a(Context paramContext, int paramInt)
  {
    return (int)(TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics()) + 0.5F);
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return b(paramContext, paramView, paramBundle);
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(b()).append(this.jdField_k_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuffer.append(((axun)localIterator.next()).a());
      }
    }
    return localStringBuffer.toString();
  }
  
  public void a(View paramView)
  {
    if (!TextUtils.isEmpty(this.b)) {}
    switch (a())
    {
    default: 
      return;
    case 0: 
      paramView.setBackgroundResource(2130838132);
      return;
    case 1: 
      paramView.setBackgroundResource(2130838133);
      return;
    case 2: 
      paramView.setBackgroundResource(2130838131);
      return;
    }
    paramView.setBackgroundResource(2130838130);
  }
  
  public void a(axun paramaxun)
  {
    if (((paramaxun instanceof axup)) && (!b())) {
      ((axup)paramaxun).S = null;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramaxun);
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((axun)localIterator.next()).a(paramAbsShareMsg);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_a_of_type_Int = paramObjectInput.readInt();
    int i1;
    int i;
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int <= 15))
    {
      this.b = paramObjectInput.readUTF();
      this.jdField_c_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_d_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_e_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_f_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_g_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_i_of_type_Int = paramObjectInput.readInt();
      this.jdField_k_of_type_Int = paramObjectInput.readInt();
      if ((2 <= this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Int <= 15)) {
        this.jdField_l_of_type_Int = paramObjectInput.readInt();
      }
      int i2 = paramObjectInput.readInt();
      i1 = 0;
      i = 1;
      if (i1 < i2)
      {
        str = paramObjectInput.readUTF();
        if ("item".equals(str)) {
          localObject = axux.a(paramObjectInput.readInt());
        }
      }
    }
    for (;;)
    {
      label182:
      str = b();
      if ((str != null) && (localObject != null) && ((localObject instanceof axwq)))
      {
        if ((!str.endsWith("Layout4")) && (!str.endsWith("Layout2")) && (!str.endsWith("Layout9"))) {
          break label350;
        }
        ((axwq)localObject).p = axwq.jdField_m_of_type_Int;
      }
      int j;
      for (;;)
      {
        if (localObject != null)
        {
          ((axun)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          ((axun)localObject).a(paramObjectInput);
          a((axun)localObject);
        }
        i1 += 1;
        break;
        localObject = axux.a(str);
        j = i;
        if ("button".equals(str))
        {
          ((axun)localObject).Q = String.valueOf(i);
          ((axun)localObject).R = this.R;
          j = i + 1;
        }
        if ((localObject == null) || (!axuo.class.isInstance(localObject))) {
          break label874;
        }
        paramObjectInput.readInt();
        i = j;
        break label182;
        label350:
        if (str.endsWith("Layout3")) {
          ((axwq)localObject).p = axwq.jdField_n_of_type_Int;
        }
      }
      if ((this.jdField_a_of_type_Int >= 3) && (this.jdField_a_of_type_Int <= 15))
      {
        this.jdField_h_of_type_JavaLangString = paramObjectInput.readUTF();
        if (this.jdField_a_of_type_Int > 5)
        {
          this.j = paramObjectInput.readUTF();
          this.jdField_k_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_l_of_type_JavaLangString = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 8) {
          this.jdField_i_of_type_JavaLangString = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 9)
        {
          this.jdField_n_of_type_JavaLangString = paramObjectInput.readUTF();
          this.o = paramObjectInput.readUTF();
          this.p = paramObjectInput.readUTF();
          this.jdField_m_of_type_JavaLangString = paramObjectInput.readUTF();
          this.q = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 10)
        {
          this.jdField_c_of_type_Int = paramObjectInput.readInt();
          this.r = paramObjectInput.readUTF();
          this.s = paramObjectInput.readUTF();
          this.t = paramObjectInput.readUTF();
          this.u = paramObjectInput.readUTF();
          this.v = paramObjectInput.readUTF();
          this.jdField_d_of_type_Int = paramObjectInput.readInt();
          this.w = paramObjectInput.readUTF();
          this.x = paramObjectInput.readUTF();
          this.y = paramObjectInput.readUTF();
          this.z = paramObjectInput.readUTF();
          this.A = paramObjectInput.readUTF();
          this.jdField_e_of_type_Int = paramObjectInput.readInt();
          this.B = paramObjectInput.readUTF();
          this.C = paramObjectInput.readUTF();
          this.D = paramObjectInput.readUTF();
          this.E = paramObjectInput.readUTF();
          this.F = paramObjectInput.readUTF();
          this.G = paramObjectInput.readUTF();
          this.H = paramObjectInput.readUTF();
          this.I = paramObjectInput.readUTF();
          this.J = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 11)
        {
          this.K = paramObjectInput.readUTF();
          this.L = paramObjectInput.readUTF();
          this.M = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 12)
        {
          this.N = paramObjectInput.readUTF();
          this.O = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 13) {
          this.jdField_f_of_type_Int = paramObjectInput.readInt();
        }
        if (this.jdField_a_of_type_Int > 14)
        {
          this.jdField_g_of_type_Int = paramObjectInput.readInt();
          this.jdField_h_of_type_Int = paramObjectInput.readInt();
        }
      }
      return;
      throw new IOException("structmsg_version_error");
      label874:
      i = j;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_n_of_type_Int);
    paramObjectOutput.writeInt(this.jdField_a_of_type_Int);
    if (this.b == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label252;
      }
      localObject = "";
      label59:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_d_of_type_JavaLangString != null) {
        break label260;
      }
      localObject = "";
      label77:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_e_of_type_JavaLangString != null) {
        break label268;
      }
      localObject = "";
      label95:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label276;
      }
      localObject = "";
      label113:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_g_of_type_JavaLangString != null) {
        break label284;
      }
    }
    label260:
    label268:
    label276:
    label284:
    for (Object localObject = "";; localObject = this.jdField_g_of_type_JavaLangString)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.jdField_i_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_k_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_l_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.i("getStructMsgFromXmlBuff", 2, "mVersion: " + this.jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((axun)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.b;
      break;
      label252:
      localObject = this.jdField_c_of_type_JavaLangString;
      break label59;
      localObject = this.jdField_d_of_type_JavaLangString;
      break label77;
      localObject = this.jdField_e_of_type_JavaLangString;
      break label95;
      localObject = this.jdField_f_of_type_JavaLangString;
      break label113;
    }
    if ((this.jdField_a_of_type_Int >= 3) && (this.jdField_a_of_type_Int <= 15))
    {
      if (this.jdField_h_of_type_JavaLangString != null) {
        break label1053;
      }
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_a_of_type_Int > 5)
      {
        if (this.j != null) {
          break label1061;
        }
        localObject = "";
        label346:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_k_of_type_JavaLangString != null) {
          break label1069;
        }
        localObject = "";
        label364:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_l_of_type_JavaLangString != null) {
          break label1077;
        }
        localObject = "";
        label382:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 8)
      {
        if (this.jdField_i_of_type_JavaLangString != null) {
          break label1085;
        }
        localObject = "";
        label409:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 9)
      {
        if (this.jdField_n_of_type_JavaLangString != null) {
          break label1093;
        }
        localObject = "";
        label436:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.o != null) {
          break label1101;
        }
        localObject = "";
        label454:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.p != null) {
          break label1109;
        }
        localObject = "";
        label472:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_m_of_type_JavaLangString != null) {
          break label1117;
        }
        localObject = "";
        label490:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.q != null) {
          break label1125;
        }
        localObject = "";
        label508:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 10)
      {
        paramObjectOutput.writeInt(this.jdField_c_of_type_Int);
        if (this.r != null) {
          break label1133;
        }
        localObject = "0";
        label545:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.s != null) {
          break label1141;
        }
        localObject = "0";
        label563:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.t != null) {
          break label1149;
        }
        localObject = "";
        label581:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.u != null) {
          break label1157;
        }
        localObject = "";
        label599:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.v != null) {
          break label1165;
        }
        localObject = "";
        label617:
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
        if (this.w != null) {
          break label1173;
        }
        localObject = "";
        label645:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.x != null) {
          break label1181;
        }
        localObject = "";
        label663:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.y != null) {
          break label1189;
        }
        localObject = "";
        label681:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.z != null) {
          break label1197;
        }
        localObject = "";
        label699:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.A != null) {
          break label1205;
        }
        localObject = "";
        label717:
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.jdField_e_of_type_Int);
        if (this.B != null) {
          break label1213;
        }
        localObject = "";
        label745:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.C != null) {
          break label1221;
        }
        localObject = "";
        label763:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.D != null) {
          break label1229;
        }
        localObject = "";
        label781:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.E != null) {
          break label1237;
        }
        localObject = "";
        label799:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.F != null) {
          break label1245;
        }
        localObject = "";
        label817:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.G != null) {
          break label1253;
        }
        localObject = "";
        label835:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.H != null) {
          break label1261;
        }
        localObject = "";
        label853:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.I != null) {
          break label1269;
        }
        localObject = "";
        label871:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.J != null) {
          break label1277;
        }
        localObject = "";
        label889:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 11)
      {
        if (this.K != null) {
          break label1285;
        }
        localObject = "";
        label916:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.L != null) {
          break label1293;
        }
        localObject = "";
        label934:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.M != null) {
          break label1301;
        }
        localObject = "";
        label952:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 12)
      {
        if (this.N != null) {
          break label1309;
        }
        localObject = "";
        label979:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.O != null) {
          break label1317;
        }
      }
    }
    label1053:
    label1181:
    label1317:
    for (localObject = "";; localObject = this.O)
    {
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_a_of_type_Int > 13) {
        paramObjectOutput.writeInt(this.jdField_f_of_type_Int);
      }
      if (this.jdField_a_of_type_Int > 14)
      {
        paramObjectOutput.writeInt(this.jdField_g_of_type_Int);
        paramObjectOutput.writeInt(this.jdField_h_of_type_Int);
      }
      return;
      localObject = this.jdField_h_of_type_JavaLangString;
      break;
      label1061:
      localObject = this.j;
      break label346;
      label1069:
      localObject = this.jdField_k_of_type_JavaLangString;
      break label364;
      label1077:
      localObject = this.jdField_l_of_type_JavaLangString;
      break label382;
      label1085:
      localObject = this.jdField_i_of_type_JavaLangString;
      break label409;
      label1093:
      localObject = this.jdField_n_of_type_JavaLangString;
      break label436;
      label1101:
      localObject = this.o;
      break label454;
      label1109:
      localObject = this.p;
      break label472;
      label1117:
      localObject = this.jdField_m_of_type_JavaLangString;
      break label490;
      label1125:
      localObject = this.q;
      break label508;
      label1133:
      localObject = this.r;
      break label545;
      label1141:
      localObject = this.s;
      break label563;
      label1149:
      localObject = this.t;
      break label581;
      localObject = this.u;
      break label599;
      localObject = this.v;
      break label617;
      localObject = this.w;
      break label645;
      localObject = this.x;
      break label663;
      label1189:
      localObject = this.y;
      break label681;
      label1197:
      localObject = this.z;
      break label699;
      label1205:
      localObject = this.A;
      break label717;
      label1213:
      localObject = this.B;
      break label745;
      label1221:
      localObject = this.C;
      break label763;
      label1229:
      localObject = this.D;
      break label781;
      label1237:
      localObject = this.E;
      break label799;
      label1245:
      localObject = this.F;
      break label817;
      label1253:
      localObject = this.G;
      break label835;
      label1261:
      localObject = this.H;
      break label853;
      label1269:
      localObject = this.I;
      break label871;
      label1277:
      localObject = this.J;
      break label889;
      localObject = this.K;
      break label916;
      localObject = this.L;
      break label934;
      localObject = this.M;
      break label952;
      localObject = this.N;
      break label979;
    }
  }
  
  public void a(String paramString)
  {
    a(new axzh(paramString));
    a(new axws());
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_k_of_type_Int = paramInt;
    a(new axwq(paramString1, paramString3));
    a(new StructMsgItemTitle(""));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, 0, "0");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(paramString1, paramString2, paramString3, paramInt, "0");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.jdField_k_of_type_Int = paramInt;
    a(new axwq(paramString1, paramString4));
    a(new StructMsgItemTitle(paramString2));
    a(new axzh(paramString3));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      a(new StructMsgItemTitle(paramString2));
    }
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      a(new axwq(paramString1));
    }
    if ((paramString3 != null) && (!paramString3.equals(""))) {
      a(new axzh(paramString3));
    }
    if ((paramString4 != null) && (!paramString4.equals(""))) {
      a(new axze(paramString4, paramString5));
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_n_of_type_Int < 0) {}
    for (Object localObject = "0";; localObject = String.valueOf(this.jdField_n_of_type_Int))
    {
      paramXmlSerializer.attribute(null, "layout", (String)localObject);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "action", this.jdField_c_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "actionData", this.jdField_d_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "a_actionData", this.jdField_e_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "i_actionData", this.jdField_f_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.b)) {
        paramXmlSerializer.attribute(null, "url", this.b);
      }
      if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "brief", this.jdField_g_of_type_JavaLangString);
      }
      if (this.jdField_i_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "flag", String.valueOf(this.jdField_i_of_type_Int));
      }
      if (this.jdField_k_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "mode", String.valueOf(this.jdField_k_of_type_Int));
      }
      if (this.jdField_l_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "bg", String.valueOf(this.jdField_l_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "businessData", this.jdField_h_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "commonData", this.jdField_i_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.j)) {
        paramXmlSerializer.attribute(null, "index", this.j);
      }
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "index_name", this.jdField_k_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "index_type", this.jdField_l_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.o)) {
        paramXmlSerializer.attribute(null, "canvas", this.o);
      }
      if (!TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "rurl", this.jdField_m_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.p)) {
        paramXmlSerializer.attribute(null, "disType", this.p);
      }
      if (!TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "tid", this.jdField_n_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.q)) {
        paramXmlSerializer.attribute(null, "apurl", this.q);
      }
      if (this.jdField_c_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "action_type", String.valueOf(this.jdField_c_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.r)) {
        paramXmlSerializer.attribute(null, "advertiser_id", this.r);
      }
      if (!TextUtils.isEmpty(this.s)) {
        paramXmlSerializer.attribute(null, "aid", this.s);
      }
      if (!TextUtils.isEmpty(this.t)) {
        paramXmlSerializer.attribute(null, "app_download_schema", this.t);
      }
      if (!TextUtils.isEmpty(this.u)) {
        paramXmlSerializer.attribute(null, "canvas_json", this.u);
      }
      if (!TextUtils.isEmpty(this.v)) {
        paramXmlSerializer.attribute(null, "customized_invoke_url", this.v);
      }
      if (this.jdField_d_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "dest_type", String.valueOf(this.jdField_d_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.w)) {
        paramXmlSerializer.attribute(null, "effect_url", this.w);
      }
      if (!TextUtils.isEmpty(this.x)) {
        paramXmlSerializer.attribute(null, "landing_page", this.x);
      }
      if (!TextUtils.isEmpty(this.y)) {
        paramXmlSerializer.attribute(null, "landing_page_report_url", this.y);
      }
      if (!TextUtils.isEmpty(this.z)) {
        paramXmlSerializer.attribute(null, "noco_id", this.z);
      }
      if (!TextUtils.isEmpty(this.A)) {
        paramXmlSerializer.attribute(null, "product_id", this.A);
      }
      if (this.jdField_e_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "product_type", String.valueOf(this.jdField_e_of_type_Int));
      }
      if (this.jdField_f_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "mini_program_type", String.valueOf(this.jdField_f_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.B)) {
        paramXmlSerializer.attribute(null, "rl", this.B);
      }
      if (!TextUtils.isEmpty(this.C)) {
        paramXmlSerializer.attribute(null, "subordinate_product_id", this.C);
      }
      if (!TextUtils.isEmpty(this.D)) {
        paramXmlSerializer.attribute(null, "traceid", this.D);
      }
      if (!TextUtils.isEmpty(this.E)) {
        paramXmlSerializer.attribute(null, "via", this.E);
      }
      if (!TextUtils.isEmpty(this.F)) {
        paramXmlSerializer.attribute(null, "video_url", this.F);
      }
      if (!TextUtils.isEmpty(this.G)) {
        paramXmlSerializer.attribute(null, "appname", this.G);
      }
      if (!TextUtils.isEmpty(this.H)) {
        paramXmlSerializer.attribute(null, "customized_invoke_url", this.H);
      }
      if (!TextUtils.isEmpty(this.I)) {
        paramXmlSerializer.attribute(null, "pkg_name", this.I);
      }
      if (!TextUtils.isEmpty(this.J)) {
        paramXmlSerializer.attribute(null, "pkgurl", this.J);
      }
      if (!TextUtils.isEmpty(this.L)) {
        paramXmlSerializer.attribute(null, "api_exposure_monitor_url", this.L);
      }
      if (!TextUtils.isEmpty(this.K)) {
        paramXmlSerializer.attribute(null, "api_click_monitor_url", this.K);
      }
      if (!TextUtils.isEmpty(this.M)) {
        paramXmlSerializer.attribute(null, "trace_info_aid", this.M);
      }
      if (!TextUtils.isEmpty(this.N)) {
        paramXmlSerializer.attribute(null, "corporate_image_name", this.N);
      }
      if (!TextUtils.isEmpty(this.O)) {
        paramXmlSerializer.attribute(null, "corporate_logo", this.O);
      }
      if (this.jdField_g_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.jdField_g_of_type_Int));
      }
      if (this.jdField_h_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "is_hidden", String.valueOf(this.jdField_h_of_type_Int));
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((axun)((Iterator)localObject).next()).a(paramXmlSerializer);
      }
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return a() == 1;
  }
  
  public boolean a(axwe paramaxwe)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramaxwe == null) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      this.jdField_c_of_type_JavaLangString = paramaxwe.a("action");
      this.jdField_d_of_type_JavaLangString = paramaxwe.a("actionData");
      this.jdField_e_of_type_JavaLangString = paramaxwe.a("a_actionData");
      this.jdField_f_of_type_JavaLangString = paramaxwe.a("i_actionData");
      this.b = paramaxwe.a("url");
      this.jdField_g_of_type_JavaLangString = paramaxwe.a("brief");
      this.q = paramaxwe.a("apurl");
      Object localObject1 = paramaxwe.a("flag");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        this.jdField_i_of_type_Int = Integer.parseInt((String)localObject1);
        localObject1 = paramaxwe.a("mode");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      catch (NumberFormatException localNumberFormatException8)
      {
        try
        {
          this.jdField_k_of_type_Int = Integer.parseInt((String)localObject1);
          localObject1 = paramaxwe.a("bg");
        }
        catch (NumberFormatException localNumberFormatException8)
        {
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              if (((String)localObject1).startsWith("#")) {
                this.jdField_l_of_type_Int = Color.parseColor((String)localObject1);
              }
            }
            else
            {
              this.jdField_h_of_type_JavaLangString = paramaxwe.a("businessData");
              this.jdField_i_of_type_JavaLangString = paramaxwe.a("commonData");
              this.j = paramaxwe.a("index");
              this.jdField_k_of_type_JavaLangString = paramaxwe.a("index_name");
              this.jdField_l_of_type_JavaLangString = paramaxwe.a("index_type");
              this.o = paramaxwe.a("canvas");
              this.jdField_m_of_type_JavaLangString = paramaxwe.a("rurl");
              this.p = paramaxwe.a("disType");
              this.jdField_n_of_type_JavaLangString = paramaxwe.a("tid");
              if (this.jdField_a_of_type_Int > 10)
              {
                localObject1 = paramaxwe.a;
                if (localObject1 != null)
                {
                  localObject3 = ((axwe)localObject1).a("action_type");
                  if (TextUtils.isEmpty((CharSequence)localObject3)) {}
                }
              }
            }
          }
          catch (IllegalArgumentException localNumberFormatException8)
          {
            try
            {
              this.jdField_c_of_type_Int = Integer.parseInt((String)localObject3);
              localObject3 = ((axwe)localObject1).a("dest_type");
              if (TextUtils.isEmpty((CharSequence)localObject3)) {}
            }
            catch (NumberFormatException localNumberFormatException8)
            {
              try
              {
                this.jdField_d_of_type_Int = Integer.parseInt((String)localObject3);
                localObject3 = ((axwe)localObject1).a("product_type");
                if (TextUtils.isEmpty((CharSequence)localObject3)) {}
              }
              catch (NumberFormatException localNumberFormatException8)
              {
                try
                {
                  this.jdField_e_of_type_Int = Integer.parseInt((String)localObject3);
                  this.r = ((axwe)localObject1).a("advertiser_id");
                  this.s = ((axwe)localObject1).a("aid");
                  this.t = ((axwe)localObject1).a("app_download_schema");
                  this.u = ((axwe)localObject1).a("canvas_json");
                  this.v = ((axwe)localObject1).a("customized_invoke_url");
                  this.w = ((axwe)localObject1).a("effect_url");
                  this.x = ((axwe)localObject1).a("landing_page");
                  this.y = ((axwe)localObject1).a("landing_page_report_url");
                  this.z = ((axwe)localObject1).a("noco_id");
                  this.A = ((axwe)localObject1).a("product_id");
                  this.B = ((axwe)localObject1).a("rl");
                  this.C = ((axwe)localObject1).a("subordinate_product_id");
                  this.D = ((axwe)localObject1).a("traceid");
                  this.E = ((axwe)localObject1).a("via");
                  this.F = ((axwe)localObject1).a("video_url");
                  this.G = ((axwe)localObject1).a("appname");
                  this.H = ((axwe)localObject1).a("customized_invoke_url");
                  this.I = ((axwe)localObject1).a("pkg_name");
                  this.J = ((axwe)localObject1).a("pkgurl");
                  this.q = ((axwe)localObject1).a("apurl");
                  if (this.jdField_a_of_type_Int > 11)
                  {
                    localObject1 = paramaxwe.a;
                    if (localObject1 != null)
                    {
                      this.K = ((axwe)localObject1).a("api_click_monitor_url");
                      this.L = ((axwe)localObject1).a("api_exposure_monitor_url");
                      this.M = ((axwe)localObject1).a("trace_info_aid");
                    }
                  }
                  if (this.jdField_a_of_type_Int > 12)
                  {
                    localObject1 = paramaxwe.a;
                    if (localObject1 != null)
                    {
                      this.N = ((axwe)localObject1).a("corporate_image_name");
                      this.O = ((axwe)localObject1).a("corporate_logo");
                    }
                  }
                  if (this.jdField_a_of_type_Int > 13)
                  {
                    localObject1 = paramaxwe.a.a("mini_program_type");
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
                  }
                }
                catch (NumberFormatException localNumberFormatException8)
                {
                  try
                  {
                    this.jdField_f_of_type_Int = Integer.parseInt((String)localObject1);
                    if (this.jdField_a_of_type_Int > 14)
                    {
                      localObject1 = paramaxwe.a;
                      if (localObject1 != null)
                      {
                        localObject3 = ((axwe)localObject1).a("tab_id");
                        if (bbjw.a((String)localObject3)) {}
                      }
                    }
                  }
                  catch (NumberFormatException localNumberFormatException8)
                  {
                    try
                    {
                      this.jdField_g_of_type_Int = Integer.parseInt((String)localObject3);
                      localObject1 = ((axwe)localObject1).a("is_hidden");
                      if (bbjw.a((String)localObject1)) {}
                    }
                    catch (NumberFormatException localNumberFormatException8)
                    {
                      try
                      {
                        for (;;)
                        {
                          Object localObject3;
                          this.jdField_h_of_type_Int = Integer.parseInt((String)localObject1);
                          int i1 = paramaxwe.a();
                          int i = 0;
                          for (;;)
                          {
                            if (i >= i1) {
                              break label1130;
                            }
                            localObject3 = paramaxwe.a(i);
                            if (localObject3 != null) {
                              break;
                            }
                            label857:
                            i += 1;
                          }
                          localNumberFormatException1 = localNumberFormatException1;
                          this.jdField_i_of_type_Int = 0;
                          continue;
                          localNumberFormatException2 = localNumberFormatException2;
                          this.jdField_k_of_type_Int = 0;
                          continue;
                          this.jdField_l_of_type_Int = Integer.parseInt(localNumberFormatException2);
                          continue;
                          localIllegalArgumentException = localIllegalArgumentException;
                          if (QLog.isColorLevel())
                          {
                            QLog.i("AbsStructMsgItem", 2, "Item bg value is " + this.jdField_l_of_type_Int);
                            continue;
                            localNumberFormatException5 = localNumberFormatException5;
                            this.jdField_c_of_type_Int = 0;
                            continue;
                            localNumberFormatException6 = localNumberFormatException6;
                            this.jdField_d_of_type_Int = 0;
                            continue;
                            localNumberFormatException7 = localNumberFormatException7;
                            this.jdField_e_of_type_Int = 0;
                            continue;
                            localNumberFormatException3 = localNumberFormatException3;
                            this.jdField_f_of_type_Int = 0;
                          }
                        }
                        localNumberFormatException8 = localNumberFormatException8;
                        this.jdField_g_of_type_Int = 0;
                      }
                      catch (NumberFormatException localNumberFormatException4)
                      {
                        for (;;)
                        {
                          this.jdField_h_of_type_Int = 0;
                        }
                        if ("item".equals(localNumberFormatException8.b)) {}
                        for (Object localObject2 = localNumberFormatException8.a("layout");; localObject2 = axux.a(localNumberFormatException8.b))
                        {
                          try
                          {
                            if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
                            for (int j = Integer.parseInt((String)localObject2);; j = 0)
                            {
                              localObject2 = axux.a(j);
                              bool1 = bool2;
                              if (localObject2 == null) {
                                break;
                              }
                              bool1 = bool2;
                              if (!((axun)localObject2).a(localNumberFormatException8)) {
                                break;
                              }
                              a((axun)localObject2);
                              break label857;
                            }
                            if (!QLog.isColorLevel()) {
                              break;
                            }
                          }
                          catch (NumberFormatException paramaxwe)
                          {
                            bool1 = bool2;
                          }
                          QLog.i("AbsStructMsgItem", 2, "Item layout value is " + 0);
                          return false;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1130:
    return true;
  }
  
  protected abstract int b();
  
  public abstract View b(Context paramContext, View paramView, Bundle paramBundle);
  
  public abstract String b();
  
  public void b(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  public void b(View paramView)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      Object localObject = paramView.getLayoutParams();
      int i = paramView.getPaddingLeft();
      int j = paramView.getPaddingTop();
      int i1 = paramView.getPaddingRight();
      int i2 = paramView.getPaddingBottom();
      switch (a())
      {
      default: 
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setPadding(i, j, i1, i2);
        localObject = paramView.findViewById(2131367947);
        if ((localObject != null) && ((localObject instanceof PAHighLightImageView))) {
          ((PAHighLightImageView)localObject).a();
        }
        break;
      }
    }
    do
    {
      return;
      paramView.setBackgroundResource(2130838132);
      break;
      paramView.setBackgroundResource(2130838133);
      break;
      paramView.setBackgroundResource(2130838131);
      break;
      paramView.setBackgroundResource(2130838130);
      break;
      paramView = paramView.findViewById(2131376572);
    } while ((paramView == null) || (!(paramView instanceof PAHighLightImageView)));
    ((PAHighLightImageView)paramView).a();
  }
  
  public void b(String paramString)
  {
    this.jdField_n_of_type_Int = 0;
    a(new axwt(paramString));
  }
  
  public void c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    int j;
    int i1;
    int i2;
    if (!TextUtils.isEmpty(this.b))
    {
      localLayoutParams = paramView.getLayoutParams();
      i = paramView.getPaddingLeft();
      j = paramView.getPaddingTop();
      i1 = paramView.getPaddingRight();
      i2 = paramView.getPaddingBottom();
      switch (a())
      {
      }
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(i, j, i1, i2);
      return;
      paramView.setBackgroundResource(2130838144);
      continue;
      paramView.setBackgroundResource(2130838147);
      continue;
      paramView.setBackgroundResource(2130838143);
      continue;
      paramView.setBackgroundResource(2130838146);
    }
  }
  
  @TargetApi(16)
  protected void d(View paramView)
  {
    if ((b()) && (a())) {
      switch (this.jdField_l_of_type_Int)
      {
      default: 
        if ((paramView != null) && (a() == 1))
        {
          if (this.jdField_m_of_type_Int == 0) {
            break label128;
          }
          paramView.setBackgroundResource(this.jdField_m_of_type_Int);
        }
        break;
      }
    }
    label128:
    StateListDrawable localStateListDrawable;
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(this.b))
        {
          this.jdField_m_of_type_Int = 2130838134;
          break;
        }
        this.jdField_m_of_type_Int = 2130838148;
        break;
        if (!TextUtils.isEmpty(this.b))
        {
          this.jdField_m_of_type_Int = 2130838135;
          break;
        }
        this.jdField_m_of_type_Int = 2130838149;
        break;
        paramView.setBackgroundResource(2130838133);
        return;
      } while ((!a()) || (this.jdField_l_of_type_Int == 0));
      int i = actn.a(4.0F, paramView.getResources());
      float f1 = i;
      float f2 = i;
      float f3 = i;
      float f4 = i;
      localStateListDrawable = axwh.a(paramView.getResources(), this.jdField_l_of_type_Int, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F });
    } while (localStateListDrawable == null);
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(localStateListDrawable);
      return;
    }
    paramView.setBackground(localStateListDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axuo
 * JD-Core Version:    0.7.0.1
 */