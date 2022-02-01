import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

class baig
  extends bahz
{
  baig(baif parambaif, vqv paramvqv, int paramInt) {}
  
  public void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    ArraySet localArraySet = new ArraySet();
    ArrayList localArrayList = new ArrayList();
    if ("QQCircleRedCircle".equals(paramString))
    {
      QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle updateNumMsg");
      if (paramList != null)
      {
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          paramList = (NumRedMsg.NumMsgBusi)paramString.next();
          if ((paramList != null) && (paramList.str_ext.get() != null)) {
            try
            {
              JSONObject localJSONObject = new JSONObject(paramList.str_ext.get());
              localArraySet.add(localJSONObject.optString("_red_ext_uin"));
              long l = baif.a(this.jdField_a_of_type_Baif);
              if (l > 0L) {
                try
                {
                  if (Long.parseLong(localJSONObject.optString("_red_ext_feed_time")) < baif.a(this.jdField_a_of_type_Baif))
                  {
                    localArrayList.add(Long.valueOf(paramList.ui64_msgid.get()));
                    baif.a(this.jdField_a_of_type_Baif, 140000, (int)paramList.ui64_msgid.get(), 3);
                  }
                }
                catch (Exception paramList)
                {
                  paramList.printStackTrace();
                  QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle ", paramList);
                }
              }
            }
            catch (Exception paramList)
            {
              paramList.printStackTrace();
              QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle ", paramList);
            }
          }
        }
        paramString = new ArrayList(localArraySet);
        if (this.jdField_a_of_type_Vqv != null)
        {
          this.jdField_a_of_type_Vqv.a(paramString, this.b);
          QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle listener returns successfully: " + paramString.size() + ", num = " + this.b);
        }
        if (baif.a(this.jdField_a_of_type_Baif) > 0L)
        {
          baif.a(this.jdField_a_of_type_Baif, 0L);
          if (localArrayList.size() > 0)
          {
            paramString = this.jdField_a_of_type_Baif.a("140000");
            baif.a(this.jdField_a_of_type_Baif, paramString, 9, false, null, localArrayList, "");
            QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle updateNumMsg updateMsgId: " + localArrayList);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baig
 * JD-Core Version:    0.7.0.1
 */