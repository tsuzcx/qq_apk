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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public abstract class bcgx
  extends bcgw
{
  public ArrayList<bcgw> a;
  public int o;
  protected int p;
  protected int q;
  public int r;
  
  protected bcgx()
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_r_of_type_Int = b();
  }
  
  protected bcgx(Collection<bcgw> paramCollection)
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramCollection);
    this.jdField_r_of_type_Int = b();
  }
  
  private boolean b()
  {
    return (this.jdField_p_of_type_Int >= 0) && (this.jdField_p_of_type_Int <= 3);
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
    localStringBuffer.append(b()).append(this.jdField_o_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuffer.append(((bcgw)localIterator.next()).a());
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
      paramView.setBackgroundResource(2130838337);
      return;
    case 1: 
      paramView.setBackgroundResource(2130838338);
      return;
    case 2: 
      paramView.setBackgroundResource(2130838336);
      return;
    }
    paramView.setBackgroundResource(2130838335);
  }
  
  public void a(bcgw parambcgw)
  {
    if (((parambcgw instanceof bcgy)) && (!b())) {
      ((bcgy)parambcgw).ac = null;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambcgw);
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bcgw)localIterator.next()).a(paramAbsShareMsg);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_a_of_type_Int = paramObjectInput.readInt();
    int k;
    int i;
    String str;
    Object localObject;
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int <= 18))
    {
      this.b = paramObjectInput.readUTF();
      this.jdField_c_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_d_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_e_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_f_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_g_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_m_of_type_Int = paramObjectInput.readInt();
      this.jdField_o_of_type_Int = paramObjectInput.readInt();
      if ((2 <= this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Int <= 18)) {
        this.jdField_p_of_type_Int = paramObjectInput.readInt();
      }
      int m = paramObjectInput.readInt();
      k = 0;
      i = 1;
      if (k < m)
      {
        str = paramObjectInput.readUTF();
        if ("item".equals(str)) {
          localObject = bchg.a(paramObjectInput.readInt());
        }
      }
    }
    for (;;)
    {
      label182:
      str = b();
      if ((str != null) && (localObject != null) && ((localObject instanceof bciz)))
      {
        if ((!str.endsWith("Layout4")) && (!str.endsWith("Layout2")) && (!str.endsWith("Layout9"))) {
          break label350;
        }
        ((bciz)localObject).t = bciz.jdField_q_of_type_Int;
      }
      int j;
      for (;;)
      {
        if (localObject != null)
        {
          ((bcgw)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          ((bcgw)localObject).a(paramObjectInput);
          a((bcgw)localObject);
        }
        k += 1;
        break;
        localObject = bchg.a(str);
        j = i;
        if ("button".equals(str))
        {
          ((bcgw)localObject).aa = String.valueOf(i);
          ((bcgw)localObject).ab = this.ab;
          j = i + 1;
        }
        if ((localObject == null) || (!bcgx.class.isInstance(localObject))) {
          break label1041;
        }
        paramObjectInput.readInt();
        i = j;
        break label182;
        label350:
        if (str.endsWith("Layout3")) {
          ((bciz)localObject).t = bciz.jdField_r_of_type_Int;
        }
      }
      if ((this.jdField_a_of_type_Int >= 3) && (this.jdField_a_of_type_Int <= 18))
      {
        this.jdField_h_of_type_JavaLangString = paramObjectInput.readUTF();
        if (this.jdField_a_of_type_Int > 5)
        {
          this.jdField_j_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_k_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_l_of_type_JavaLangString = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 8) {
          this.jdField_i_of_type_JavaLangString = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 9)
        {
          this.n = paramObjectInput.readUTF();
          this.jdField_o_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_p_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_m_of_type_JavaLangString = paramObjectInput.readUTF();
          this.jdField_q_of_type_JavaLangString = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 10)
        {
          this.jdField_c_of_type_Int = paramObjectInput.readInt();
          this.jdField_r_of_type_JavaLangString = paramObjectInput.readUTF();
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
        if (this.jdField_a_of_type_Int > 15)
        {
          this.P = paramObjectInput.readUTF();
          this.Q = paramObjectInput.readUTF();
          this.R = paramObjectInput.readUTF();
          this.jdField_i_of_type_Int = paramObjectInput.readInt();
          this.jdField_j_of_type_Int = paramObjectInput.readInt();
          this.jdField_k_of_type_Int = paramObjectInput.readInt();
          this.jdField_l_of_type_Int = paramObjectInput.readInt();
          this.S = paramObjectInput.readUTF();
          this.T = paramObjectInput.readUTF();
          this.U = paramObjectInput.readUTF();
          this.V = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 16) {
          this.W = paramObjectInput.readUTF();
        }
        if (this.jdField_a_of_type_Int > 17)
        {
          this.X = paramObjectInput.readUTF();
          this.Y = paramObjectInput.readUTF();
        }
      }
      return;
      throw new IOException("structmsg_version_error");
      label1041:
      i = j;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_r_of_type_Int);
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
      paramObjectOutput.writeInt(this.jdField_m_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_o_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_p_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.i("getStructMsgFromXmlBuff", 2, "mVersion: " + this.jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bcgw)((Iterator)localObject).next()).a(paramObjectOutput);
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
    if ((this.jdField_a_of_type_Int >= 3) && (this.jdField_a_of_type_Int <= 18))
    {
      if (this.jdField_h_of_type_JavaLangString != null) {
        break label1300;
      }
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_a_of_type_Int > 5)
      {
        if (this.jdField_j_of_type_JavaLangString != null) {
          break label1308;
        }
        localObject = "";
        label346:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_k_of_type_JavaLangString != null) {
          break label1316;
        }
        localObject = "";
        label364:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_l_of_type_JavaLangString != null) {
          break label1324;
        }
        localObject = "";
        label382:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 8)
      {
        if (this.jdField_i_of_type_JavaLangString != null) {
          break label1332;
        }
        localObject = "";
        label409:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 9)
      {
        if (this.n != null) {
          break label1340;
        }
        localObject = "";
        label436:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_o_of_type_JavaLangString != null) {
          break label1348;
        }
        localObject = "";
        label454:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_p_of_type_JavaLangString != null) {
          break label1356;
        }
        localObject = "";
        label472:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_m_of_type_JavaLangString != null) {
          break label1364;
        }
        localObject = "";
        label490:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_q_of_type_JavaLangString != null) {
          break label1372;
        }
        localObject = "";
        label508:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 10)
      {
        paramObjectOutput.writeInt(this.jdField_c_of_type_Int);
        if (this.jdField_r_of_type_JavaLangString != null) {
          break label1380;
        }
        localObject = "0";
        label545:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.s != null) {
          break label1388;
        }
        localObject = "0";
        label563:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.t != null) {
          break label1396;
        }
        localObject = "";
        label581:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.u != null) {
          break label1404;
        }
        localObject = "";
        label599:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.v != null) {
          break label1412;
        }
        localObject = "";
        label617:
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
        if (this.w != null) {
          break label1420;
        }
        localObject = "";
        label645:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.x != null) {
          break label1428;
        }
        localObject = "";
        label663:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.y != null) {
          break label1436;
        }
        localObject = "";
        label681:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.z != null) {
          break label1444;
        }
        localObject = "";
        label699:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.A != null) {
          break label1452;
        }
        localObject = "";
        label717:
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.jdField_e_of_type_Int);
        if (this.B != null) {
          break label1460;
        }
        localObject = "";
        label745:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.C != null) {
          break label1468;
        }
        localObject = "";
        label763:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.D != null) {
          break label1476;
        }
        localObject = "";
        label781:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.E != null) {
          break label1484;
        }
        localObject = "";
        label799:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.F != null) {
          break label1492;
        }
        localObject = "";
        label817:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.G != null) {
          break label1500;
        }
        localObject = "";
        label835:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.H != null) {
          break label1508;
        }
        localObject = "";
        label853:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.I != null) {
          break label1516;
        }
        localObject = "";
        label871:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.J != null) {
          break label1524;
        }
        localObject = "";
        label889:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 11)
      {
        if (this.K != null) {
          break label1532;
        }
        localObject = "";
        label916:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.L != null) {
          break label1540;
        }
        localObject = "";
        label934:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.M != null) {
          break label1548;
        }
        localObject = "";
        label952:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 12)
      {
        if (this.N != null) {
          break label1556;
        }
        localObject = "";
        label979:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.O != null) {
          break label1564;
        }
        localObject = "";
        label997:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 13) {
        paramObjectOutput.writeInt(this.jdField_f_of_type_Int);
      }
      if (this.jdField_a_of_type_Int > 14)
      {
        paramObjectOutput.writeInt(this.jdField_g_of_type_Int);
        paramObjectOutput.writeInt(this.jdField_h_of_type_Int);
      }
      if (this.jdField_a_of_type_Int > 15)
      {
        if (this.P != null) {
          break label1572;
        }
        localObject = "";
        label1072:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.Q != null) {
          break label1580;
        }
        localObject = "";
        label1090:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.R != null) {
          break label1588;
        }
        localObject = "";
        label1108:
        paramObjectOutput.writeUTF((String)localObject);
        paramObjectOutput.writeInt(this.jdField_i_of_type_Int);
        paramObjectOutput.writeInt(this.jdField_j_of_type_Int);
        paramObjectOutput.writeInt(this.jdField_k_of_type_Int);
        paramObjectOutput.writeInt(this.jdField_l_of_type_Int);
        if (this.S != null) {
          break label1596;
        }
        localObject = "";
        label1166:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.T != null) {
          break label1604;
        }
        localObject = "";
        label1184:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.U != null) {
          break label1612;
        }
        localObject = "";
        label1202:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.V != null) {
          break label1620;
        }
        localObject = "";
        label1220:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 16)
      {
        if (this.W != null) {
          break label1628;
        }
        localObject = "";
        label1247:
        paramObjectOutput.writeUTF((String)localObject);
      }
      if (this.jdField_a_of_type_Int > 17)
      {
        if (this.X != null) {
          break label1636;
        }
        localObject = "";
        label1274:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.Y != null) {
          break label1644;
        }
      }
    }
    label1300:
    label1308:
    label1316:
    label1324:
    label1332:
    label1340:
    label1348:
    label1356:
    label1364:
    label1372:
    label1380:
    label1644:
    for (localObject = "";; localObject = this.Y)
    {
      paramObjectOutput.writeUTF((String)localObject);
      return;
      localObject = this.jdField_h_of_type_JavaLangString;
      break;
      localObject = this.jdField_j_of_type_JavaLangString;
      break label346;
      localObject = this.jdField_k_of_type_JavaLangString;
      break label364;
      localObject = this.jdField_l_of_type_JavaLangString;
      break label382;
      localObject = this.jdField_i_of_type_JavaLangString;
      break label409;
      localObject = this.n;
      break label436;
      localObject = this.jdField_o_of_type_JavaLangString;
      break label454;
      localObject = this.jdField_p_of_type_JavaLangString;
      break label472;
      localObject = this.jdField_m_of_type_JavaLangString;
      break label490;
      localObject = this.jdField_q_of_type_JavaLangString;
      break label508;
      localObject = this.jdField_r_of_type_JavaLangString;
      break label545;
      label1388:
      localObject = this.s;
      break label563;
      label1396:
      localObject = this.t;
      break label581;
      label1404:
      localObject = this.u;
      break label599;
      localObject = this.v;
      break label617;
      localObject = this.w;
      break label645;
      localObject = this.x;
      break label663;
      localObject = this.y;
      break label681;
      localObject = this.z;
      break label699;
      localObject = this.A;
      break label717;
      localObject = this.B;
      break label745;
      localObject = this.C;
      break label763;
      localObject = this.D;
      break label781;
      localObject = this.E;
      break label799;
      localObject = this.F;
      break label817;
      localObject = this.G;
      break label835;
      localObject = this.H;
      break label853;
      label1516:
      localObject = this.I;
      break label871;
      label1524:
      localObject = this.J;
      break label889;
      label1532:
      localObject = this.K;
      break label916;
      localObject = this.L;
      break label934;
      localObject = this.M;
      break label952;
      localObject = this.N;
      break label979;
      localObject = this.O;
      break label997;
      localObject = this.P;
      break label1072;
      localObject = this.Q;
      break label1090;
      localObject = this.R;
      break label1108;
      localObject = this.S;
      break label1166;
      localObject = this.T;
      break label1184;
      localObject = this.U;
      break label1202;
      localObject = this.V;
      break label1220;
      localObject = this.W;
      break label1247;
      localObject = this.X;
      break label1274;
    }
  }
  
  public void a(String paramString)
  {
    a(new bclv(paramString));
    a(new bcjb());
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_o_of_type_Int = paramInt;
    a(new bciz(paramString1, paramString3));
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
    this.jdField_o_of_type_Int = paramInt;
    a(new bciz(paramString1, paramString4));
    a(new StructMsgItemTitle(paramString2));
    a(new bclv(paramString3));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.jdField_o_of_type_Int = paramInt;
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      a(new StructMsgItemTitle(paramString2));
    }
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      a(new bciz(paramString1));
    }
    if ((paramString3 != null) && (!paramString3.equals(""))) {
      a(new bclv(paramString3));
    }
    if ((paramString4 != null) && (!paramString4.equals(""))) {
      a(new bcls(paramString4, paramString5));
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_r_of_type_Int < 0) {}
    for (Object localObject = "0";; localObject = String.valueOf(this.jdField_r_of_type_Int))
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
      if (this.jdField_m_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "flag", String.valueOf(this.jdField_m_of_type_Int));
      }
      if (this.jdField_o_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "mode", String.valueOf(this.jdField_o_of_type_Int));
      }
      if (this.jdField_p_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "bg", String.valueOf(this.jdField_p_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "businessData", this.jdField_h_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "commonData", this.jdField_i_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "index", this.jdField_j_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "index_name", this.jdField_k_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "index_type", this.jdField_l_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "canvas", this.jdField_o_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "rurl", this.jdField_m_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "disType", this.jdField_p_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.n)) {
        paramXmlSerializer.attribute(null, "tid", this.n);
      }
      if (!TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "apurl", this.jdField_q_of_type_JavaLangString);
      }
      if (this.jdField_c_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "action_type", String.valueOf(this.jdField_c_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "advertiser_id", this.jdField_r_of_type_JavaLangString);
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
      if (!TextUtils.isEmpty(this.P)) {
        paramXmlSerializer.attribute(null, "negative_feedback_url", this.P);
      }
      if (!TextUtils.isEmpty(this.Q)) {
        paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.Q);
      }
      if (!TextUtils.isEmpty(this.R)) {
        paramXmlSerializer.attribute(null, "sdk_click_monitor_url", this.R);
      }
      if (this.jdField_i_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "media_duration", String.valueOf(this.jdField_i_of_type_Int));
      }
      if (this.jdField_j_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "video_file_size", String.valueOf(this.jdField_j_of_type_Int));
      }
      if (this.jdField_k_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "app_score_num", String.valueOf(this.jdField_k_of_type_Int));
      }
      if (this.jdField_l_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "download_num", String.valueOf(this.jdField_l_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.S)) {
        paramXmlSerializer.attribute(null, "universal_link", this.S);
      }
      if (!TextUtils.isEmpty(this.T)) {
        paramXmlSerializer.attribute(null, "sdk_data", this.T);
      }
      if (!TextUtils.isEmpty(this.U)) {
        paramXmlSerializer.attribute(null, "tencent_video_id", this.U);
      }
      if (!TextUtils.isEmpty(this.V)) {
        paramXmlSerializer.attribute(null, "view_id", this.V);
      }
      if (!TextUtils.isEmpty(this.W)) {
        paramXmlSerializer.attribute(null, "qgg_ext", this.W);
      }
      if (!TextUtils.isEmpty(this.X)) {
        paramXmlSerializer.attribute(null, "adInfo", this.X);
      }
      if (!TextUtils.isEmpty(this.Y)) {
        paramXmlSerializer.attribute(null, "is_report_click", this.Y);
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bcgw)((Iterator)localObject).next()).a(paramXmlSerializer);
      }
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return a() == 1;
  }
  
  public boolean a(bcin parambcin)
  {
    boolean bool2 = false;
    boolean bool1;
    if (parambcin == null) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      this.jdField_c_of_type_JavaLangString = parambcin.a("action");
      this.jdField_d_of_type_JavaLangString = parambcin.a("actionData");
      this.jdField_e_of_type_JavaLangString = parambcin.a("a_actionData");
      this.jdField_f_of_type_JavaLangString = parambcin.a("i_actionData");
      this.b = parambcin.a("url");
      this.jdField_g_of_type_JavaLangString = parambcin.a("brief");
      this.jdField_q_of_type_JavaLangString = parambcin.a("apurl");
      Object localObject1 = parambcin.a("flag");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        this.jdField_m_of_type_Int = Integer.parseInt((String)localObject1);
        localObject1 = parambcin.a("mode");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      catch (NumberFormatException localNumberFormatException11)
      {
        try
        {
          this.jdField_o_of_type_Int = Integer.parseInt((String)localObject1);
          localObject1 = parambcin.a("bg");
        }
        catch (NumberFormatException localNumberFormatException11)
        {
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              if (((String)localObject1).startsWith("#")) {
                this.jdField_p_of_type_Int = Color.parseColor((String)localObject1);
              }
            }
            else
            {
              this.jdField_h_of_type_JavaLangString = parambcin.a("businessData");
              this.jdField_i_of_type_JavaLangString = parambcin.a("commonData");
              this.jdField_j_of_type_JavaLangString = parambcin.a("index");
              this.jdField_k_of_type_JavaLangString = parambcin.a("index_name");
              this.jdField_l_of_type_JavaLangString = parambcin.a("index_type");
              this.jdField_o_of_type_JavaLangString = parambcin.a("canvas");
              this.jdField_m_of_type_JavaLangString = parambcin.a("rurl");
              this.jdField_p_of_type_JavaLangString = parambcin.a("disType");
              this.n = parambcin.a("tid");
              if (this.jdField_a_of_type_Int > 10)
              {
                localObject1 = parambcin.a;
                if (localObject1 != null)
                {
                  localObject3 = ((bcin)localObject1).a("action_type");
                  if (TextUtils.isEmpty((CharSequence)localObject3)) {}
                }
              }
            }
          }
          catch (IllegalArgumentException localNumberFormatException11)
          {
            try
            {
              this.jdField_c_of_type_Int = Integer.parseInt((String)localObject3);
              localObject3 = ((bcin)localObject1).a("dest_type");
              if (TextUtils.isEmpty((CharSequence)localObject3)) {}
            }
            catch (NumberFormatException localNumberFormatException11)
            {
              try
              {
                this.jdField_d_of_type_Int = Integer.parseInt((String)localObject3);
                localObject3 = ((bcin)localObject1).a("product_type");
                if (TextUtils.isEmpty((CharSequence)localObject3)) {}
              }
              catch (NumberFormatException localNumberFormatException11)
              {
                try
                {
                  this.jdField_e_of_type_Int = Integer.parseInt((String)localObject3);
                  this.jdField_r_of_type_JavaLangString = ((bcin)localObject1).a("advertiser_id");
                  this.s = ((bcin)localObject1).a("aid");
                  this.t = ((bcin)localObject1).a("app_download_schema");
                  this.u = ((bcin)localObject1).a("canvas_json");
                  this.v = ((bcin)localObject1).a("customized_invoke_url");
                  this.w = ((bcin)localObject1).a("effect_url");
                  this.x = ((bcin)localObject1).a("landing_page");
                  this.y = ((bcin)localObject1).a("landing_page_report_url");
                  this.z = ((bcin)localObject1).a("noco_id");
                  this.A = ((bcin)localObject1).a("product_id");
                  this.B = ((bcin)localObject1).a("rl");
                  this.C = ((bcin)localObject1).a("subordinate_product_id");
                  this.D = ((bcin)localObject1).a("traceid");
                  this.E = ((bcin)localObject1).a("via");
                  this.F = ((bcin)localObject1).a("video_url");
                  this.G = ((bcin)localObject1).a("appname");
                  this.H = ((bcin)localObject1).a("customized_invoke_url");
                  this.I = ((bcin)localObject1).a("pkg_name");
                  this.J = ((bcin)localObject1).a("pkgurl");
                  this.jdField_q_of_type_JavaLangString = ((bcin)localObject1).a("apurl");
                  if (this.jdField_a_of_type_Int > 11)
                  {
                    localObject1 = parambcin.a;
                    if (localObject1 != null)
                    {
                      this.K = ((bcin)localObject1).a("api_click_monitor_url");
                      this.L = ((bcin)localObject1).a("api_exposure_monitor_url");
                      this.M = ((bcin)localObject1).a("trace_info_aid");
                    }
                  }
                  if (this.jdField_a_of_type_Int > 12)
                  {
                    localObject1 = parambcin.a;
                    if (localObject1 != null)
                    {
                      this.N = ((bcin)localObject1).a("corporate_image_name");
                      this.O = ((bcin)localObject1).a("corporate_logo");
                    }
                  }
                  if (this.jdField_a_of_type_Int > 13)
                  {
                    localObject1 = parambcin.a.a("mini_program_type");
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
                  }
                }
                catch (NumberFormatException localNumberFormatException11)
                {
                  try
                  {
                    this.jdField_f_of_type_Int = Integer.parseInt((String)localObject1);
                    if (this.jdField_a_of_type_Int > 14)
                    {
                      localObject1 = parambcin.a;
                      if (localObject1 != null)
                      {
                        localObject3 = ((bcin)localObject1).a("tab_id");
                        if (StringUtil.isEmpty((String)localObject3)) {}
                      }
                    }
                  }
                  catch (NumberFormatException localNumberFormatException11)
                  {
                    try
                    {
                      this.jdField_g_of_type_Int = Integer.parseInt((String)localObject3);
                      localObject1 = ((bcin)localObject1).a("is_hidden");
                      if (StringUtil.isEmpty((String)localObject1)) {}
                    }
                    catch (NumberFormatException localNumberFormatException11)
                    {
                      try
                      {
                        this.jdField_h_of_type_Int = Integer.parseInt((String)localObject1);
                        if (this.jdField_a_of_type_Int > 15)
                        {
                          localObject1 = parambcin.a;
                          this.P = ((bcin)localObject1).a("negative_feedback_url");
                          this.Q = ((bcin)localObject1).a("sdk_exposure_monitor_url");
                          this.R = ((bcin)localObject1).a("sdk_click_monitor_url");
                          localObject3 = ((bcin)localObject1).a("media_duration");
                          if (StringUtil.isEmpty((String)localObject3)) {}
                        }
                      }
                      catch (NumberFormatException localNumberFormatException11)
                      {
                        try
                        {
                          this.jdField_i_of_type_Int = Integer.parseInt((String)localObject3);
                          localObject3 = ((bcin)localObject1).a("video_file_size");
                          if (StringUtil.isEmpty((String)localObject3)) {}
                        }
                        catch (NumberFormatException localNumberFormatException11)
                        {
                          try
                          {
                            this.jdField_j_of_type_Int = Integer.parseInt((String)localObject3);
                            localObject3 = ((bcin)localObject1).a("app_score_num");
                            if (StringUtil.isEmpty((String)localObject3)) {}
                          }
                          catch (NumberFormatException localNumberFormatException11)
                          {
                            try
                            {
                              this.jdField_k_of_type_Int = Integer.parseInt((String)localObject3);
                              localObject3 = ((bcin)localObject1).a("download_num");
                              if (StringUtil.isEmpty((String)localObject3)) {}
                            }
                            catch (NumberFormatException localNumberFormatException11)
                            {
                              try
                              {
                                for (;;)
                                {
                                  Object localObject3;
                                  this.jdField_l_of_type_Int = Integer.parseInt((String)localObject3);
                                  this.S = ((bcin)localObject1).a("universal_link");
                                  this.T = ((bcin)localObject1).a("sdk_data");
                                  this.U = ((bcin)localObject1).a("tencent_video_id");
                                  this.V = ((bcin)localObject1).a("view_id");
                                  if (this.jdField_a_of_type_Int > 16) {
                                    this.W = parambcin.a.a("qgg_ext");
                                  }
                                  if (this.jdField_a_of_type_Int > 17)
                                  {
                                    localObject1 = parambcin.a;
                                    this.X = ((bcin)localObject1).a("adInfo");
                                    this.Y = ((bcin)localObject1).a("is_report_click");
                                  }
                                  int k = parambcin.a();
                                  int i = 0;
                                  for (;;)
                                  {
                                    if (i >= k) {
                                      break label1439;
                                    }
                                    localObject3 = parambcin.a(i);
                                    if (localObject3 != null) {
                                      break;
                                    }
                                    label1126:
                                    i += 1;
                                  }
                                  localNumberFormatException1 = localNumberFormatException1;
                                  this.jdField_m_of_type_Int = 0;
                                  continue;
                                  localNumberFormatException2 = localNumberFormatException2;
                                  this.jdField_o_of_type_Int = 0;
                                  continue;
                                  this.jdField_p_of_type_Int = Integer.parseInt(localNumberFormatException2);
                                  continue;
                                  localIllegalArgumentException = localIllegalArgumentException;
                                  if (QLog.isColorLevel())
                                  {
                                    QLog.i("AbsStructMsgItem", 2, "Item bg value is " + this.jdField_p_of_type_Int);
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
                                    continue;
                                    localNumberFormatException8 = localNumberFormatException8;
                                    this.jdField_g_of_type_Int = 0;
                                    continue;
                                    localNumberFormatException4 = localNumberFormatException4;
                                    this.jdField_h_of_type_Int = 0;
                                    continue;
                                    localNumberFormatException9 = localNumberFormatException9;
                                    this.jdField_i_of_type_Int = 0;
                                    continue;
                                    localNumberFormatException10 = localNumberFormatException10;
                                    this.jdField_j_of_type_Int = 0;
                                  }
                                }
                                localNumberFormatException11 = localNumberFormatException11;
                                this.jdField_k_of_type_Int = 0;
                              }
                              catch (NumberFormatException localNumberFormatException12)
                              {
                                for (;;)
                                {
                                  this.jdField_l_of_type_Int = 0;
                                }
                                if ("item".equals(localNumberFormatException12.b)) {}
                                for (Object localObject2 = localNumberFormatException12.a("layout");; localObject2 = bchg.a(localNumberFormatException12.b))
                                {
                                  try
                                  {
                                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
                                    for (int j = Integer.parseInt((String)localObject2);; j = 0)
                                    {
                                      localObject2 = bchg.a(j);
                                      bool1 = bool2;
                                      if (localObject2 == null) {
                                        break;
                                      }
                                      bool1 = bool2;
                                      if (!((bcgw)localObject2).a(localNumberFormatException12)) {
                                        break;
                                      }
                                      a((bcgw)localObject2);
                                      break label1126;
                                    }
                                    if (!QLog.isColorLevel()) {
                                      break;
                                    }
                                  }
                                  catch (NumberFormatException parambcin)
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
          }
        }
      }
    }
    label1439:
    return true;
  }
  
  protected abstract int b();
  
  public abstract View b(Context paramContext, View paramView, Bundle paramBundle);
  
  public abstract String b();
  
  public void b(int paramInt)
  {
    this.jdField_o_of_type_Int = paramInt;
  }
  
  public void b(View paramView)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      Object localObject = paramView.getLayoutParams();
      int i = paramView.getPaddingLeft();
      int j = paramView.getPaddingTop();
      int k = paramView.getPaddingRight();
      int m = paramView.getPaddingBottom();
      switch (a())
      {
      default: 
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setPadding(i, j, k, m);
        localObject = paramView.findViewById(2131368518);
        if ((localObject != null) && ((localObject instanceof PAHighLightImageView))) {
          ((PAHighLightImageView)localObject).a();
        }
        break;
      }
    }
    do
    {
      return;
      paramView.setBackgroundResource(2130838337);
      break;
      paramView.setBackgroundResource(2130838338);
      break;
      paramView.setBackgroundResource(2130838336);
      break;
      paramView.setBackgroundResource(2130838335);
      break;
      paramView = paramView.findViewById(2131377859);
    } while ((paramView == null) || (!(paramView instanceof PAHighLightImageView)));
    ((PAHighLightImageView)paramView).a();
  }
  
  public void b(String paramString)
  {
    this.jdField_r_of_type_Int = 0;
    a(new bcjc(paramString));
  }
  
  public void c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    int j;
    int k;
    int m;
    if (!TextUtils.isEmpty(this.b))
    {
      localLayoutParams = paramView.getLayoutParams();
      i = paramView.getPaddingLeft();
      j = paramView.getPaddingTop();
      k = paramView.getPaddingRight();
      m = paramView.getPaddingBottom();
      switch (a())
      {
      }
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(i, j, k, m);
      return;
      paramView.setBackgroundResource(2130838349);
      continue;
      paramView.setBackgroundResource(2130838352);
      continue;
      paramView.setBackgroundResource(2130838348);
      continue;
      paramView.setBackgroundResource(2130838351);
    }
  }
  
  @TargetApi(16)
  protected void d(View paramView)
  {
    if ((b()) && (a())) {
      switch (this.jdField_p_of_type_Int)
      {
      default: 
        if ((paramView != null) && (a() == 1))
        {
          if (this.jdField_q_of_type_Int == 0) {
            break label128;
          }
          paramView.setBackgroundResource(this.jdField_q_of_type_Int);
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
          this.jdField_q_of_type_Int = 2130838339;
          break;
        }
        this.jdField_q_of_type_Int = 2130838353;
        break;
        if (!TextUtils.isEmpty(this.b))
        {
          this.jdField_q_of_type_Int = 2130838340;
          break;
        }
        this.jdField_q_of_type_Int = 2130838354;
        break;
        paramView.setBackgroundResource(2130838338);
        return;
      } while ((!a()) || (this.jdField_p_of_type_Int == 0));
      int i = AIOUtils.dp2px(4.0F, paramView.getResources());
      float f1 = i;
      float f2 = i;
      float f3 = i;
      float f4 = i;
      localStateListDrawable = bciq.a(paramView.getResources(), this.jdField_p_of_type_Int, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F });
    } while (localStateListDrawable == null);
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(localStateListDrawable);
      return;
    }
    paramView.setBackground(localStateListDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgx
 * JD-Core Version:    0.7.0.1
 */