import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bqhv
  extends bqgi
  implements DialogInterface.OnDismissListener, bqhz
{
  public static String a;
  private float jdField_a_of_type_Float;
  private bqhy jdField_a_of_type_Bqhy;
  private bqyd jdField_a_of_type_Bqyd;
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditVideoVote";
  }
  
  public bqhv(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
  }
  
  private JSONObject a(@NonNull bqhy parambqhy)
  {
    bqkh localbqkh = a().a();
    if (localbqkh != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("v", 1);
        localJSONObject1.put("id", 1);
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(zps.a(a())), Integer.valueOf(zps.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbqkh.u * localbqkh.q), Float.valueOf(localbqkh.v * localbqkh.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbqkh.b.x + localbqkh.s), Float.valueOf(localbqkh.b.y + localbqkh.t) }));
        parambqhy = new JSONArray(Arrays.asList(parambqhy.jdField_a_of_type_ArrayOfJavaLangString));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", localJSONArray1);
        localJSONObject2.put("ls", localJSONArray2);
        localJSONObject2.put("lp", localJSONArray3);
        localJSONObject2.put("r", localbqkh.r);
        localJSONObject2.put("c", parambqhy);
        localJSONObject1.put("a", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException parambqhy)
      {
        yuk.e("Q.qqstory.publish.edit.EditVideoVote", parambqhy.toString());
      }
    }
    return null;
  }
  
  public static void a(Bundle paramBundle, bqkh parambqkh)
  {
    if (parambqkh != null)
    {
      paramBundle.putFloat("scale", parambqkh.q);
      paramBundle.putFloat("rotate", parambqkh.r);
      paramBundle.putFloat("translateX", parambqkh.s);
      paramBundle.putFloat("translateY", parambqkh.t);
    }
  }
  
  private void a(bqhy parambqhy, int paramInt)
  {
    if (this.jdField_a_of_type_Bqyd != null) {
      j();
    }
    this.jdField_a_of_type_Bqyd = new bqyd(a(), this, parambqhy, paramInt);
    this.jdField_a_of_type_Bqyd.setContentView(2131561925);
    this.jdField_a_of_type_Bqyd.setOnDismissListener(this);
    this.jdField_a_of_type_Bqyd.show();
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bqyd != null) && (this.jdField_a_of_type_Bqyd.isShowing()))
    {
      this.jdField_a_of_type_Bqyd.dismiss();
      this.jdField_a_of_type_Bqyd = null;
    }
  }
  
  public bqhy a()
  {
    return this.jdField_a_of_type_Bqhy;
  }
  
  @NonNull
  public bqkf a()
  {
    Object localObject = (bqbr)a(bqbr.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bqbr)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("VoteLayer is null.");
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    a(bqhz.class, this);
  }
  
  public void a(Bundle paramBundle, String[] paramArrayOfString, Bitmap paramBitmap, Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Float = paramBundle.getFloat("scale");
      this.b = paramBundle.getFloat("rotate");
      this.c = paramBundle.getFloat("translateX");
      this.d = paramBundle.getFloat("translateY");
    }
    a(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
  }
  
  public void a(bqkh parambqkh, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bqhy == null)
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoVote", "why vote info is null????");
      this.jdField_a_of_type_Bqgk.a(35);
      return;
    }
    Object localObject = new bqrj().c(parambqkh);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    ((Matrix)localObject).mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0];
    paramFloat2 = parambqkh.u / 2.0F;
    float f1 = arrayOfFloat[1];
    float f2 = parambqkh.v / 2.0F;
    localObject = new Bundle();
    a((Bundle)localObject, parambqkh);
    ((Bundle)localObject).putInt("element_index", zox.a(this.jdField_a_of_type_Bqhy.jdField_a_of_type_ArrayOfAndroidGraphicsRect, (int)(paramFloat1 + paramFloat2), (int)(f1 + f2)));
    this.jdField_a_of_type_Bqgk.a(35, localObject);
    parambqkh.l = false;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      bqkh localbqkh = a().a();
      if (localbqkh != null) {}
      try
      {
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(zps.a(a())), Integer.valueOf(zps.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbqkh.u * localbqkh.q), Float.valueOf(localbqkh.v * localbqkh.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbqkh.b.x + localbqkh.s), Float.valueOf(localbqkh.b.y + localbqkh.t) }));
        JSONArray localJSONArray4 = new JSONArray(Arrays.asList(this.jdField_a_of_type_Bqhy.jdField_a_of_type_ArrayOfJavaLangString));
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localbqkh.jdField_a_of_type_ArrayOfAndroidGraphicsRect != null)
        {
          localObject1 = localObject2;
          if (localbqkh.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length > 0)
          {
            localObject2 = new JSONArray();
            Rect[] arrayOfRect = localbqkh.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
            int j = arrayOfRect.length;
            for (;;)
            {
              localObject1 = localObject2;
              if (i >= j) {
                break;
              }
              localObject1 = arrayOfRect[i];
              ((JSONArray)localObject2).put(localObject1.left);
              ((JSONArray)localObject2).put(localObject1.top);
              ((JSONArray)localObject2).put(localObject1.right);
              ((JSONArray)localObject2).put(localObject1.bottom);
              i += 1;
            }
          }
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ss", localJSONArray1);
        ((JSONObject)localObject2).put("ls", localJSONArray2);
        ((JSONObject)localObject2).put("lp", localJSONArray3);
        ((JSONObject)localObject2).put("r", localbqkh.r);
        ((JSONObject)localObject2).put("c", localJSONArray4);
        if (localObject1 != null) {
          ((JSONObject)localObject2).put("tr", localObject1);
        }
        paramJSONObject.put(jdField_a_of_type_JavaLangString, localObject2);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        yuk.e("Q.qqstory.publish.edit.EditVideoVote", paramJSONObject.toString());
        return;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bqhs == null)
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bqhy = new bqhy(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bqhs == null)
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bqhy = new bqhy(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bqyd != null) && (this.jdField_a_of_type_Bqyd.isShowing()))
    {
      j();
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      j();
      return;
    }
    int i = -1;
    paramInt = i;
    if (paramObject != null)
    {
      paramInt = i;
      if ((paramObject instanceof Bundle))
      {
        paramObject = (Bundle)paramObject;
        paramInt = paramObject.getInt("element_index");
        this.jdField_a_of_type_Float = paramObject.getFloat("scale");
        this.b = paramObject.getFloat("rotate");
        this.c = paramObject.getFloat("translateX");
        this.d = paramObject.getFloat("translateY");
      }
    }
    a(this.jdField_a_of_type_Bqhy, paramInt);
    a().e();
    yup.a("video_edit", "clk_vote_entry", 1, 0, new String[0]);
  }
  
  public void b(int paramInt, bqua parambqua)
  {
    bqhy localbqhy = this.jdField_a_of_type_Bqhy;
    if (localbqhy != null)
    {
      ((bpnf)bplq.a(15)).a(null);
      Object localObject = a(localbqhy);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).toString();
        yuk.a("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote json:%s", localObject);
        parambqua.a.putExtra("pl", localObject);
        parambqua = new StringBuilder();
        localObject = localbqhy.jdField_a_of_type_ArrayOfJavaLangString;
        int i = localObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          parambqua.append(localObject[paramInt]).append(";");
          paramInt += 1;
        }
        parambqua.deleteCharAt(parambqua.length() - 1);
        localObject = parambqua.toString();
        if (localbqhy.jdField_a_of_type_Boolean) {}
        for (parambqua = "1";; parambqua = "2")
        {
          yup.a("video_edit", "pub_vote", 1, 0, new String[] { localObject, parambqua });
          yup.a("video_edit_new", "qa_send", 1, 0, new String[0]);
          return;
        }
      }
      yuk.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, parse vote json error.");
      return;
    }
    yuk.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote layer is empty.");
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_Bqhy;
    int i;
    if (localObject != null)
    {
      i = 0;
      if (i >= ((bqhy)localObject).jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label115;
      }
      if (!TextUtils.isEmpty(localObject.jdField_a_of_type_ArrayOfJavaLangString[i])) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        Context localContext = a();
        if (i == 0) {}
        for (localObject = anzj.a(2131702620);; localObject = anzj.a(2131702699))
        {
          bhlq.a(localContext, 230, (String)localObject, null, anzj.a(2131702808), anzj.a(2131702763), new bqhw(this, i), new bqhx(this)).show();
          return false;
          i += 1;
          break;
        }
      }
      return true;
      label115:
      i = -1;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bqhy = null;
    yuk.b("Q.qqstory.publish.edit.EditVideoVote", "deleteVote.");
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bqgk.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqhv
 * JD-Core Version:    0.7.0.1
 */