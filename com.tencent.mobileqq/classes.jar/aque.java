import android.text.TextUtils;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.Elem;
import appoint.define.appoint_define.Face;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.notColumn;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aque
{
  public int a;
  public long a;
  public aqui a;
  public String a;
  public aqui b;
  public String b;
  public String c;
  public String d;
  public String e;
  @notColumn
  public String f;
  
  public static aque a(appoint_define.DateComment paramDateComment)
  {
    if ((paramDateComment == null) || (TextUtils.isEmpty(paramDateComment.str_comment_id.get()))) {
      return null;
    }
    aque localaque = new aque();
    localaque.jdField_a_of_type_JavaLangString = paramDateComment.str_comment_id.get();
    localaque.jdField_b_of_type_JavaLangString = aquj.a((appoint_define.AppointID)paramDateComment.msg_appoint_id.get());
    localaque.jdField_a_of_type_Long = paramDateComment.uint32_time.get();
    appoint_define.RichText localRichText;
    int i;
    if (paramDateComment.msg_content.has())
    {
      localRichText = (appoint_define.RichText)paramDateComment.msg_content.get();
      localaque.c = a(localRichText);
      localaque.jdField_a_of_type_Aqui = aqui.a((appoint_define.StrangerInfo)paramDateComment.msg_publisher_info.get());
      if (!paramDateComment.uint32_flag.has()) {
        break label220;
      }
      i = paramDateComment.uint32_flag.get();
      label131:
      localaque.jdField_a_of_type_Int = i;
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
        localaque.d = paramDateComment.str_comment_id.get();
        localaque.jdField_b_of_type_Aqui = aqui.a((appoint_define.StrangerInfo)paramDateComment.msg_stranger_info.get());
      }
      localaque.f = aquj.a(localaque.jdField_a_of_type_Long, true);
      localaque.e = aquj.a(localaque.jdField_a_of_type_Long, false);
      return localaque;
      localRichText = null;
      break;
      i = 0;
      break label131;
    }
  }
  
  public static aque a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    aque localaque = new aque();
    try
    {
      localaque.jdField_a_of_type_JavaLangString = paramJSONObject.getString("commentId");
      localaque.jdField_b_of_type_JavaLangString = paramJSONObject.getString("datingId");
      localaque.c = paramJSONObject.getString("content");
      localaque.jdField_a_of_type_Long = paramJSONObject.getLong("time");
      localaque.jdField_a_of_type_Aqui = aqui.a(paramJSONObject.getJSONObject("puber"));
      localaque.jdField_a_of_type_Int = paramJSONObject.getInt("flag");
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        for (;;)
        {
          localaque.d = paramJSONObject.getString("replyId");
          try
          {
            localaque.jdField_b_of_type_Aqui = aqui.a(paramJSONObject.getJSONObject("replyer"));
            return localaque;
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return localaque;
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
    label187:
    label190:
    label192:
    label195:
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
            break label187;
          }
          paramRichText = (appoint_define.Face)localElem.msg_face_info.get();
          if (paramRichText == null) {
            break label190;
          }
          if (!paramRichText.uint32_index.has()) {
            break label192;
          }
        }
        for (int i = paramRichText.uint32_index.get();; i = -1)
        {
          if (i < 0) {
            break label195;
          }
          localStringBuilder.append('\024');
          localStringBuilder.append((char)QQSysFaceUtil.convertToLocal(i));
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
  
  public static String a(List<aque> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((aque)paramList.next());
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
  
  public static JSONObject a(aque paramaque)
  {
    if (paramaque == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("commentId", paramaque.jdField_a_of_type_JavaLangString);
      localJSONObject.put("datingId", paramaque.jdField_b_of_type_JavaLangString);
      localJSONObject.put("content", paramaque.c);
      localJSONObject.put("time", paramaque.jdField_a_of_type_Long);
      localJSONObject.put("replyId", paramaque.d);
      localJSONObject.put("puber", aqui.a(paramaque.jdField_a_of_type_Aqui));
      localJSONObject.put("replyer", aqui.a(paramaque.jdField_b_of_type_Aqui));
      localJSONObject.put("flag", paramaque.jdField_a_of_type_Int);
      return localJSONObject;
    }
    catch (JSONException paramaque)
    {
      paramaque.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<aque> paramList, String paramString)
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
          aque localaque = a(paramString.getJSONObject(i));
          if (localaque != null) {
            paramList.add(localaque);
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
      paramObject = (aque)paramObject;
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
    localStringBuilder.append("[").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_b_of_type_JavaLangString).append(",").append(this.c).append(",").append(this.jdField_a_of_type_Long).append(",").append(this.d).append(",").append(this.jdField_a_of_type_Aqui).append(",").append(this.jdField_b_of_type_Aqui).append(",").append(this.jdField_a_of_type_Int).append(",").append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aque
 * JD-Core Version:    0.7.0.1
 */