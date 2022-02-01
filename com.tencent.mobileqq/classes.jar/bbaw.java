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

class bbaw
  extends bbap
{
  bbaw(bbav parambbav, vtg paramvtg, int paramInt) {}
  
  public void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    ArraySet localArraySet = new ArraySet();
    ArrayList localArrayList = new ArrayList();
    if ("QQCircleRedCircle".equals(paramString))
    {
      QLog.d("RedPointLog.RedTouchManager", 1, "getPassiveRedNumQQCircle updateNumMsg");
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
              long l = bbav.a(this.jdField_a_of_type_Bbav);
              if (l > 0L) {
                try
                {
                  if (Long.parseLong(localJSONObject.optString("_red_ext_feed_time")) < bbav.a(this.jdField_a_of_type_Bbav))
                  {
                    localArrayList.add(Long.valueOf(paramList.ui64_msgid.get()));
                    bbav.a(this.jdField_a_of_type_Bbav, 140000, (int)paramList.ui64_msgid.get(), 3);
                  }
                }
                catch (Exception paramList)
                {
                  paramList.printStackTrace();
                  QLog.d("RedPointLog.RedTouchManager", 1, "getPassiveRedNumQQCircle ", paramList);
                }
              }
            }
            catch (Exception paramList)
            {
              paramList.printStackTrace();
              QLog.d("RedPointLog.RedTouchManager", 1, "getPassiveRedNumQQCircle ", paramList);
            }
          }
        }
        paramString = new ArrayList(localArraySet);
        if (this.jdField_a_of_type_Vtg != null)
        {
          this.jdField_a_of_type_Vtg.a(paramString, this.b);
          QLog.d("RedPointLog.RedTouchManager", 1, "getPassiveRedNumQQCircle listener returns successfully: " + paramString.size() + ", num = " + this.b);
        }
        if (bbav.a(this.jdField_a_of_type_Bbav) > 0L)
        {
          bbav.a(this.jdField_a_of_type_Bbav, 0L);
          if (localArrayList.size() > 0)
          {
            paramString = this.jdField_a_of_type_Bbav.a("140000");
            bbav.a(this.jdField_a_of_type_Bbav, paramString, 9, false, null, localArrayList, "");
            QLog.d("RedPointLog.RedTouchManager", 1, "getPassiveRedNumQQCircle updateNumMsg updateMsgId: " + localArrayList);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbaw
 * JD-Core Version:    0.7.0.1
 */