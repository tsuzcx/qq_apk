import android.text.TextUtils;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.Elem;
import appoint.define.appoint_define.Face;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anmg
{
  public int a;
  public long a;
  public anmk a;
  public String a;
  public anmk b;
  public String b;
  public String c;
  public String d;
  public String e;
  @aulz
  public String f;
  
  public static anmg a(appoint_define.DateComment paramDateComment)
  {
    if ((paramDateComment == null) || (TextUtils.isEmpty(paramDateComment.str_comment_id.get()))) {
      return null;
    }
    anmg localanmg = new anmg();
    localanmg.jdField_a_of_type_JavaLangString = paramDateComment.str_comment_id.get();
    localanmg.jdField_b_of_type_JavaLangString = anml.a((appoint_define.AppointID)paramDateComment.msg_appoint_id.get());
    localanmg.jdField_a_of_type_Long = paramDateComment.uint32_time.get();
    appoint_define.RichText localRichText;
    int i;
    if (paramDateComment.msg_content.has())
    {
      localRichText = (appoint_define.RichText)paramDateComment.msg_content.get();
      localanmg.c = a(localRichText);
      localanmg.jdField_a_of_type_Anmk = anmk.a((appoint_define.StrangerInfo)paramDateComment.msg_publisher_info.get());
      if (!paramDateComment.uint32_flag.has()) {
        break label220;
      }
      i = paramDateComment.uint32_flag.get();
      label131:
      localanmg.jdField_a_of_type_Int = i;
      if (!paramDateComment.msg_reply_info.has()) {
        break label225;
      }
    }
    label220:
    label225:
    for (paramDateComment = (appoint_define.ReplyInfo)paramDateComment.msg_reply_info.get();; paramDateComment = null)
    {
      if (paramDateComment != null)
      {
        localanmg.d = paramDateComment.str_comment_id.get();
        localanmg.jdField_b_of_type_Anmk = anmk.a((appoint_define.StrangerInfo)paramDateComment.msg_stranger_info.get());
      }
      localanmg.f = anml.a(localanmg.jdField_a_of_type_Long, true);
      localanmg.e = anml.a(localanmg.jdField_a_of_type_Long, false);
      return localanmg;
      localRichText = null;
      break;
      i = 0;
      break label131;
    }
  }
  
  public static anmg a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    anmg localanmg = new anmg();
    try
    {
      localanmg.jdField_a_of_type_JavaLangString = paramJSONObject.getString("commentId");
      localanmg.jdField_b_of_type_JavaLangString = paramJSONObject.getString("datingId");
      localanmg.c = paramJSONObject.getString("content");
      localanmg.jdField_a_of_type_Long = paramJSONObject.getLong("time");
      localanmg.jdField_a_of_type_Anmk = anmk.a(paramJSONObject.getJSONObject("puber"));
      localanmg.jdField_a_of_type_Int = paramJSONObject.getInt("flag");
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        for (;;)
        {
          localanmg.d = paramJSONObject.getString("replyId");
          try
          {
            localanmg.jdField_b_of_type_Anmk = anmk.a(paramJSONObject.getJSONObject("replyer"));
            return localanmg;
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return localanmg;
          }
          localJSONException1 = localJSONException1;
          localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  public static String a(appoint_define.RichText paramRichText)
  {
    if (paramRichText == null) {
      return "";
    }
    if (paramRichText.rpt_msg_elems.has()) {}
    for (paramRichText = paramRichText.rpt_msg_elems.get(); (paramRichText == null) || (paramRichText.isEmpty()); paramRichText = null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramRichText.iterator();
    label135:
    label196:
    label199:
    label201:
    label204:
    while (localIterator.hasNext())
    {
      appoint_define.Elem localElem = (appoint_define.Elem)localIterator.next();
      if (localElem != null)
      {
        if (localElem.str_content.has())
        {
          paramRichText = localElem.str_content.get();
          label106:
          localStringBuilder.append(paramRichText);
          if (!localElem.msg_face_info.has()) {
            break label196;
          }
          paramRichText = (appoint_define.Face)localElem.msg_face_info.get();
          if (paramRichText == null) {
            break label199;
          }
          if (!paramRichText.uint32_index.has()) {
            break label201;
          }
        }
        for (int i = paramRichText.uint32_index.get();; i = -1)
        {
          if ((i < 0) || (i >= axau.b.length)) {
            break label204;
          }
          localStringBuilder.append('\024');
          localStringBuilder.append((char)axau.b[i]);
          break;
          paramRichText = "";
          break label106;
          paramRichText = null;
          break label135;
          break;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(List<anmg> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((anmg)paramList.next());
      if (localJSONObject == null) {
        break label83;
      }
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    label83:
    for (;;)
    {
      if (i >= 20) {
        return localJSONArray.toString();
      }
      break;
    }
  }
  
  public static JSONObject a(anmg paramanmg)
  {
    if (paramanmg == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("commentId", paramanmg.jdField_a_of_type_JavaLangString);
      localJSONObject.put("datingId", paramanmg.jdField_b_of_type_JavaLangString);
      localJSONObject.put("content", paramanmg.c);
      localJSONObject.put("time", paramanmg.jdField_a_of_type_Long);
      localJSONObject.put("replyId", paramanmg.d);
      localJSONObject.put("puber", anmk.a(paramanmg.jdField_a_of_type_Anmk));
      localJSONObject.put("replyer", anmk.a(paramanmg.jdField_b_of_type_Anmk));
      localJSONObject.put("flag", paramanmg.jdField_a_of_type_Int);
      return localJSONObject;
    }
    catch (JSONException paramanmg)
    {
      paramanmg.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<anmg> paramList, String paramString)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          anmg localanmg = a(paramString.getJSONObject(i));
          if (localanmg != null) {
            paramList.add(localanmg);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (anmg)paramObject;
    } while (((this.jdField_a_of_type_JavaLangString != null) || (paramObject.jdField_a_of_type_JavaLangString != null)) && ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString))));
    return true;
  }
  
  public int hashCode()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "".hashCode();
    }
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_b_of_type_JavaLangString).append(",").append(this.c).append(",").append(this.jdField_a_of_type_Long).append(",").append(this.d).append(",").append(this.jdField_a_of_type_Anmk).append(",").append(this.jdField_b_of_type_Anmk).append(",").append(this.jdField_a_of_type_Int).append(",").append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anmg
 * JD-Core Version:    0.7.0.1
 */