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

public class bmki
  extends bmiv
  implements DialogInterface.OnDismissListener, bmkm
{
  public static String a;
  private float jdField_a_of_type_Float;
  private bmkl jdField_a_of_type_Bmkl;
  private bnaq jdField_a_of_type_Bnaq;
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditVideoVote";
  }
  
  public bmki(@NonNull bmix parambmix)
  {
    super(parambmix);
  }
  
  private JSONObject a(@NonNull bmkl parambmkl)
  {
    bmmu localbmmu = a().a();
    if (localbmmu != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("v", 1);
        localJSONObject1.put("id", 1);
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(xod.a(a())), Integer.valueOf(xod.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmmu.u * localbmmu.q), Float.valueOf(localbmmu.v * localbmmu.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmmu.b.x + localbmmu.s), Float.valueOf(localbmmu.b.y + localbmmu.t) }));
        parambmkl = new JSONArray(Arrays.asList(parambmkl.jdField_a_of_type_ArrayOfJavaLangString));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", localJSONArray1);
        localJSONObject2.put("ls", localJSONArray2);
        localJSONObject2.put("lp", localJSONArray3);
        localJSONObject2.put("r", localbmmu.r);
        localJSONObject2.put("c", parambmkl);
        localJSONObject1.put("a", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException parambmkl)
      {
        wsv.e("Q.qqstory.publish.edit.EditVideoVote", parambmkl.toString());
      }
    }
    return null;
  }
  
  public static void a(Bundle paramBundle, bmmu parambmmu)
  {
    if (parambmmu != null)
    {
      paramBundle.putFloat("scale", parambmmu.q);
      paramBundle.putFloat("rotate", parambmmu.r);
      paramBundle.putFloat("translateX", parambmmu.s);
      paramBundle.putFloat("translateY", parambmmu.t);
    }
  }
  
  private void a(bmkl parambmkl, int paramInt)
  {
    if (this.jdField_a_of_type_Bnaq != null) {
      j();
    }
    this.jdField_a_of_type_Bnaq = new bnaq(a(), this, parambmkl, paramInt);
    this.jdField_a_of_type_Bnaq.setContentView(2131561632);
    this.jdField_a_of_type_Bnaq.setOnDismissListener(this);
    this.jdField_a_of_type_Bnaq.show();
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bnaq != null) && (this.jdField_a_of_type_Bnaq.isShowing()))
    {
      this.jdField_a_of_type_Bnaq.dismiss();
      this.jdField_a_of_type_Bnaq = null;
    }
  }
  
  public bmkl a()
  {
    return this.jdField_a_of_type_Bmkl;
  }
  
  @NonNull
  public bmms a()
  {
    Object localObject = (bmee)a(bmee.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bmee)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("VoteLayer is null.");
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    a(bmkm.class, this);
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
  
  public void a(bmmu parambmmu, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bmkl == null)
    {
      wsv.e("Q.qqstory.publish.edit.EditVideoVote", "why vote info is null????");
      this.jdField_a_of_type_Bmix.a(35);
      return;
    }
    Object localObject = new bmtw().c(parambmmu);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    ((Matrix)localObject).mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0];
    paramFloat2 = parambmmu.u / 2.0F;
    float f1 = arrayOfFloat[1];
    float f2 = parambmmu.v / 2.0F;
    localObject = new Bundle();
    a((Bundle)localObject, parambmmu);
    ((Bundle)localObject).putInt("element_index", xni.a(this.jdField_a_of_type_Bmkl.jdField_a_of_type_ArrayOfAndroidGraphicsRect, (int)(paramFloat1 + paramFloat2), (int)(f1 + f2)));
    this.jdField_a_of_type_Bmix.a(35, localObject);
    parambmmu.l = false;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      bmmu localbmmu = a().a();
      if (localbmmu != null) {}
      try
      {
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(xod.a(a())), Integer.valueOf(xod.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmmu.u * localbmmu.q), Float.valueOf(localbmmu.v * localbmmu.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmmu.b.x + localbmmu.s), Float.valueOf(localbmmu.b.y + localbmmu.t) }));
        JSONArray localJSONArray4 = new JSONArray(Arrays.asList(this.jdField_a_of_type_Bmkl.jdField_a_of_type_ArrayOfJavaLangString));
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localbmmu.jdField_a_of_type_ArrayOfAndroidGraphicsRect != null)
        {
          localObject1 = localObject2;
          if (localbmmu.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length > 0)
          {
            localObject2 = new JSONArray();
            Rect[] arrayOfRect = localbmmu.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
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
        ((JSONObject)localObject2).put("r", localbmmu.r);
        ((JSONObject)localObject2).put("c", localJSONArray4);
        if (localObject1 != null) {
          ((JSONObject)localObject2).put("tr", localObject1);
        }
        paramJSONObject.put(jdField_a_of_type_JavaLangString, localObject2);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        wsv.e("Q.qqstory.publish.edit.EditVideoVote", paramJSONObject.toString());
        return;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bmkf == null)
    {
      wsv.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bmkl = new bmkl(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bmkf == null)
    {
      wsv.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bmkl = new bmkl(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bnaq != null) && (this.jdField_a_of_type_Bnaq.isShowing()))
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
    a(this.jdField_a_of_type_Bmkl, paramInt);
    a().e();
    wta.a("video_edit", "clk_vote_entry", 1, 0, new String[0]);
  }
  
  public void b(int paramInt, bmwn parambmwn)
  {
    bmkl localbmkl = this.jdField_a_of_type_Bmkl;
    if (localbmkl != null)
    {
      ((blnu)blmf.a(15)).a(null);
      Object localObject = a(localbmkl);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).toString();
        wsv.a("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote json:%s", localObject);
        parambmwn.a.putExtra("pl", localObject);
        parambmwn = new StringBuilder();
        localObject = localbmkl.jdField_a_of_type_ArrayOfJavaLangString;
        int i = localObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          parambmwn.append(localObject[paramInt]).append(";");
          paramInt += 1;
        }
        parambmwn.deleteCharAt(parambmwn.length() - 1);
        localObject = parambmwn.toString();
        if (localbmkl.jdField_a_of_type_Boolean) {}
        for (parambmwn = "1";; parambmwn = "2")
        {
          wta.a("video_edit", "pub_vote", 1, 0, new String[] { localObject, parambmwn });
          wta.a("video_edit_new", "qa_send", 1, 0, new String[0]);
          return;
        }
      }
      wsv.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, parse vote json error.");
      return;
    }
    wsv.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote layer is empty.");
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_Bmkl;
    int i;
    if (localObject != null)
    {
      i = 0;
      if (i >= ((bmkl)localObject).jdField_a_of_type_ArrayOfJavaLangString.length) {
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
        for (localObject = alpo.a(2131704104);; localObject = alpo.a(2131704183))
        {
          bdcd.a(localContext, 230, (String)localObject, null, alpo.a(2131704292), alpo.a(2131704247), new bmkj(this, i), new bmkk(this)).show();
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
    this.jdField_a_of_type_Bmkl = null;
    wsv.b("Q.qqstory.publish.edit.EditVideoVote", "deleteVote.");
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bmix.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmki
 * JD-Core Version:    0.7.0.1
 */