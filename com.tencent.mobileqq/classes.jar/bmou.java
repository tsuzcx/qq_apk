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

public class bmou
  extends bmnh
  implements DialogInterface.OnDismissListener, bmoy
{
  public static String a;
  private float jdField_a_of_type_Float;
  private bmox jdField_a_of_type_Bmox;
  private bnfc jdField_a_of_type_Bnfc;
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditVideoVote";
  }
  
  public bmou(@NonNull bmnj parambmnj)
  {
    super(parambmnj);
  }
  
  private JSONObject a(@NonNull bmox parambmox)
  {
    bmrg localbmrg = a().a();
    if (localbmrg != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("v", 1);
        localJSONObject1.put("id", 1);
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(xsm.a(a())), Integer.valueOf(xsm.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmrg.u * localbmrg.q), Float.valueOf(localbmrg.v * localbmrg.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmrg.b.x + localbmrg.s), Float.valueOf(localbmrg.b.y + localbmrg.t) }));
        parambmox = new JSONArray(Arrays.asList(parambmox.jdField_a_of_type_ArrayOfJavaLangString));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", localJSONArray1);
        localJSONObject2.put("ls", localJSONArray2);
        localJSONObject2.put("lp", localJSONArray3);
        localJSONObject2.put("r", localbmrg.r);
        localJSONObject2.put("c", parambmox);
        localJSONObject1.put("a", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException parambmox)
      {
        wxe.e("Q.qqstory.publish.edit.EditVideoVote", parambmox.toString());
      }
    }
    return null;
  }
  
  public static void a(Bundle paramBundle, bmrg parambmrg)
  {
    if (parambmrg != null)
    {
      paramBundle.putFloat("scale", parambmrg.q);
      paramBundle.putFloat("rotate", parambmrg.r);
      paramBundle.putFloat("translateX", parambmrg.s);
      paramBundle.putFloat("translateY", parambmrg.t);
    }
  }
  
  private void a(bmox parambmox, int paramInt)
  {
    if (this.jdField_a_of_type_Bnfc != null) {
      j();
    }
    this.jdField_a_of_type_Bnfc = new bnfc(a(), this, parambmox, paramInt);
    this.jdField_a_of_type_Bnfc.setContentView(2131561650);
    this.jdField_a_of_type_Bnfc.setOnDismissListener(this);
    this.jdField_a_of_type_Bnfc.show();
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bnfc != null) && (this.jdField_a_of_type_Bnfc.isShowing()))
    {
      this.jdField_a_of_type_Bnfc.dismiss();
      this.jdField_a_of_type_Bnfc = null;
    }
  }
  
  public bmox a()
  {
    return this.jdField_a_of_type_Bmox;
  }
  
  @NonNull
  public bmre a()
  {
    Object localObject = (bmiq)a(bmiq.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bmiq)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("VoteLayer is null.");
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    a(bmoy.class, this);
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
  
  public void a(bmrg parambmrg, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bmox == null)
    {
      wxe.e("Q.qqstory.publish.edit.EditVideoVote", "why vote info is null????");
      this.jdField_a_of_type_Bmnj.a(35);
      return;
    }
    Object localObject = new bmyi().c(parambmrg);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    ((Matrix)localObject).mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0];
    paramFloat2 = parambmrg.u / 2.0F;
    float f1 = arrayOfFloat[1];
    float f2 = parambmrg.v / 2.0F;
    localObject = new Bundle();
    a((Bundle)localObject, parambmrg);
    ((Bundle)localObject).putInt("element_index", xrr.a(this.jdField_a_of_type_Bmox.jdField_a_of_type_ArrayOfAndroidGraphicsRect, (int)(paramFloat1 + paramFloat2), (int)(f1 + f2)));
    this.jdField_a_of_type_Bmnj.a(35, localObject);
    parambmrg.l = false;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      bmrg localbmrg = a().a();
      if (localbmrg != null) {}
      try
      {
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(xsm.a(a())), Integer.valueOf(xsm.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmrg.u * localbmrg.q), Float.valueOf(localbmrg.v * localbmrg.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmrg.b.x + localbmrg.s), Float.valueOf(localbmrg.b.y + localbmrg.t) }));
        JSONArray localJSONArray4 = new JSONArray(Arrays.asList(this.jdField_a_of_type_Bmox.jdField_a_of_type_ArrayOfJavaLangString));
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localbmrg.jdField_a_of_type_ArrayOfAndroidGraphicsRect != null)
        {
          localObject1 = localObject2;
          if (localbmrg.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length > 0)
          {
            localObject2 = new JSONArray();
            Rect[] arrayOfRect = localbmrg.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
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
        ((JSONObject)localObject2).put("r", localbmrg.r);
        ((JSONObject)localObject2).put("c", localJSONArray4);
        if (localObject1 != null) {
          ((JSONObject)localObject2).put("tr", localObject1);
        }
        paramJSONObject.put(jdField_a_of_type_JavaLangString, localObject2);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        wxe.e("Q.qqstory.publish.edit.EditVideoVote", paramJSONObject.toString());
        return;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bmor == null)
    {
      wxe.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bmox = new bmox(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bmor == null)
    {
      wxe.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bmox = new bmox(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bnfc != null) && (this.jdField_a_of_type_Bnfc.isShowing()))
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
    a(this.jdField_a_of_type_Bmox, paramInt);
    a().e();
    wxj.a("video_edit", "clk_vote_entry", 1, 0, new String[0]);
  }
  
  public void b(int paramInt, bnaz parambnaz)
  {
    bmox localbmox = this.jdField_a_of_type_Bmox;
    if (localbmox != null)
    {
      ((blsg)blqr.a(15)).a(null);
      Object localObject = a(localbmox);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).toString();
        wxe.a("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote json:%s", localObject);
        parambnaz.a.putExtra("pl", localObject);
        parambnaz = new StringBuilder();
        localObject = localbmox.jdField_a_of_type_ArrayOfJavaLangString;
        int i = localObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          parambnaz.append(localObject[paramInt]).append(";");
          paramInt += 1;
        }
        parambnaz.deleteCharAt(parambnaz.length() - 1);
        localObject = parambnaz.toString();
        if (localbmox.jdField_a_of_type_Boolean) {}
        for (parambnaz = "1";; parambnaz = "2")
        {
          wxj.a("video_edit", "pub_vote", 1, 0, new String[] { localObject, parambnaz });
          wxj.a("video_edit_new", "qa_send", 1, 0, new String[0]);
          return;
        }
      }
      wxe.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, parse vote json error.");
      return;
    }
    wxe.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote layer is empty.");
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_Bmox;
    int i;
    if (localObject != null)
    {
      i = 0;
      if (i >= ((bmox)localObject).jdField_a_of_type_ArrayOfJavaLangString.length) {
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
        for (localObject = alud.a(2131704116);; localObject = alud.a(2131704195))
        {
          bdgm.a(localContext, 230, (String)localObject, null, alud.a(2131704304), alud.a(2131704259), new bmov(this, i), new bmow(this)).show();
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
    this.jdField_a_of_type_Bmox = null;
    wxe.b("Q.qqstory.publish.edit.EditVideoVote", "deleteVote.");
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bmnj.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmou
 * JD-Core Version:    0.7.0.1
 */