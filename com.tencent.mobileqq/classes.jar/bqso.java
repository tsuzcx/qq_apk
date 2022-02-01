import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.linker.LinkerObject.1;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

public class bqso
  implements ThreadExcutor.IThreadListener
{
  public int a;
  bqsp a;
  public final String a;
  public String b;
  public String c;
  public String d;
  
  public bqso(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static bqso a(String paramString)
  {
    bqso localbqso = new bqso(paramString);
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("LinkerObject", 2, "parse Url:" + paramString);
        }
        localObject = String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s&req_from=riji", new Object[] { BaseApplicationImpl.getApplication().getRuntime().getAccount(), URLEncoder.encode(paramString) });
        localObject = nnr.a(BaseApplicationImpl.getApplication().getApplicationContext(), (String)localObject, null, "GET", null, null, 10000, 10000);
        int i;
        if ((localObject != null) && (((HttpResponse)localObject).getStatusLine().getStatusCode() == 200))
        {
          localObject = new JSONObject(nnr.a((HttpResponse)localObject));
          i = Integer.parseInt(((JSONObject)localObject).getString("ret"));
          if (i == 0)
          {
            str = ((JSONObject)localObject).getString("title");
            if (!TextUtils.isEmpty(str)) {
              localbqso.b = str;
            }
            str = ((JSONObject)localObject).getString("abstract");
            if (!TextUtils.isEmpty(str)) {
              localbqso.c = str;
            }
            localbqso.jdField_a_of_type_Int = 0;
            if (!((JSONObject)localObject).has("errTypeCode")) {
              break label357;
            }
            str = "2";
            localObject = ((JSONObject)localObject).getString("errTypeCode");
            yup.a("video_edit", "url_rich", 0, 0, new String[] { str, localObject, paramString });
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("LinkerObject", 2, "parse result,mResultCode:" + localbqso.jdField_a_of_type_Int + ",mShareTitle:" + localbqso.b + ",mShareDesc:" + localbqso.c + ",mShareThumb:" + localbqso.d);
          return localbqso;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("LinkerObject", 2, "parse fail,reportServerCode:" + i + ",json:" + localObject);
        continue;
        String str = "1";
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return localbqso;
      }
      label357:
      Object localObject = null;
    }
    return localbqso;
  }
  
  public void a(bqsp parambqsp)
  {
    this.jdField_a_of_type_Bqsp = parambqsp;
  }
  
  public void a(String paramString)
  {
    ThreadManagerV2.excute(new LinkerObject.1(this, paramString), 128, this, true);
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c));
  }
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (this.jdField_a_of_type_Bqsp != null)
    {
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Bqsp.a(this);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bqsp.a(this, this.jdField_a_of_type_Int);
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqso
 * JD-Core Version:    0.7.0.1
 */