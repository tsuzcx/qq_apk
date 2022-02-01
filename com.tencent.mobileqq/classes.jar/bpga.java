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

public class bpga
  extends bpen
  implements DialogInterface.OnDismissListener, bpge
{
  public static String a;
  private float jdField_a_of_type_Float;
  private bpgd jdField_a_of_type_Bpgd;
  private bpwi jdField_a_of_type_Bpwi;
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditVideoVote";
  }
  
  public bpga(@NonNull bpep parambpep)
  {
    super(parambpep);
  }
  
  private JSONObject a(@NonNull bpgd parambpgd)
  {
    bpim localbpim = a().a();
    if (localbpim != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("v", 1);
        localJSONObject1.put("id", 1);
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(zlx.a(a())), Integer.valueOf(zlx.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbpim.u * localbpim.q), Float.valueOf(localbpim.v * localbpim.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbpim.b.x + localbpim.s), Float.valueOf(localbpim.b.y + localbpim.t) }));
        parambpgd = new JSONArray(Arrays.asList(parambpgd.jdField_a_of_type_ArrayOfJavaLangString));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", localJSONArray1);
        localJSONObject2.put("ls", localJSONArray2);
        localJSONObject2.put("lp", localJSONArray3);
        localJSONObject2.put("r", localbpim.r);
        localJSONObject2.put("c", parambpgd);
        localJSONObject1.put("a", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException parambpgd)
      {
        yqp.e("Q.qqstory.publish.edit.EditVideoVote", parambpgd.toString());
      }
    }
    return null;
  }
  
  public static void a(Bundle paramBundle, bpim parambpim)
  {
    if (parambpim != null)
    {
      paramBundle.putFloat("scale", parambpim.q);
      paramBundle.putFloat("rotate", parambpim.r);
      paramBundle.putFloat("translateX", parambpim.s);
      paramBundle.putFloat("translateY", parambpim.t);
    }
  }
  
  private void a(bpgd parambpgd, int paramInt)
  {
    if (this.jdField_a_of_type_Bpwi != null) {
      j();
    }
    this.jdField_a_of_type_Bpwi = new bpwi(a(), this, parambpgd, paramInt);
    this.jdField_a_of_type_Bpwi.setContentView(2131561884);
    this.jdField_a_of_type_Bpwi.setOnDismissListener(this);
    this.jdField_a_of_type_Bpwi.show();
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bpwi != null) && (this.jdField_a_of_type_Bpwi.isShowing()))
    {
      this.jdField_a_of_type_Bpwi.dismiss();
      this.jdField_a_of_type_Bpwi = null;
    }
  }
  
  public bpgd a()
  {
    return this.jdField_a_of_type_Bpgd;
  }
  
  @NonNull
  public bpik a()
  {
    Object localObject = (bozw)a(bozw.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bozw)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("VoteLayer is null.");
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    a(bpge.class, this);
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
  
  public void a(bpim parambpim, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bpgd == null)
    {
      yqp.e("Q.qqstory.publish.edit.EditVideoVote", "why vote info is null????");
      this.jdField_a_of_type_Bpep.a(35);
      return;
    }
    Object localObject = new bppo().c(parambpim);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    ((Matrix)localObject).mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0];
    paramFloat2 = parambpim.u / 2.0F;
    float f1 = arrayOfFloat[1];
    float f2 = parambpim.v / 2.0F;
    localObject = new Bundle();
    a((Bundle)localObject, parambpim);
    ((Bundle)localObject).putInt("element_index", zlc.a(this.jdField_a_of_type_Bpgd.jdField_a_of_type_ArrayOfAndroidGraphicsRect, (int)(paramFloat1 + paramFloat2), (int)(f1 + f2)));
    this.jdField_a_of_type_Bpep.a(35, localObject);
    parambpim.l = false;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      bpim localbpim = a().a();
      if (localbpim != null) {}
      try
      {
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(zlx.a(a())), Integer.valueOf(zlx.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbpim.u * localbpim.q), Float.valueOf(localbpim.v * localbpim.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbpim.b.x + localbpim.s), Float.valueOf(localbpim.b.y + localbpim.t) }));
        JSONArray localJSONArray4 = new JSONArray(Arrays.asList(this.jdField_a_of_type_Bpgd.jdField_a_of_type_ArrayOfJavaLangString));
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localbpim.jdField_a_of_type_ArrayOfAndroidGraphicsRect != null)
        {
          localObject1 = localObject2;
          if (localbpim.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length > 0)
          {
            localObject2 = new JSONArray();
            Rect[] arrayOfRect = localbpim.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
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
        ((JSONObject)localObject2).put("r", localbpim.r);
        ((JSONObject)localObject2).put("c", localJSONArray4);
        if (localObject1 != null) {
          ((JSONObject)localObject2).put("tr", localObject1);
        }
        paramJSONObject.put(jdField_a_of_type_JavaLangString, localObject2);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        yqp.e("Q.qqstory.publish.edit.EditVideoVote", paramJSONObject.toString());
        return;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bpfx == null)
    {
      yqp.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bpgd = new bpgd(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bpfx == null)
    {
      yqp.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bpgd = new bpgd(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bpwi != null) && (this.jdField_a_of_type_Bpwi.isShowing()))
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
    a(this.jdField_a_of_type_Bpgd, paramInt);
    a().e();
    yqu.a("video_edit", "clk_vote_entry", 1, 0, new String[0]);
  }
  
  public void b(int paramInt, bpsf parambpsf)
  {
    bpgd localbpgd = this.jdField_a_of_type_Bpgd;
    if (localbpgd != null)
    {
      ((bolk)bojv.a(15)).a(null);
      Object localObject = a(localbpgd);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).toString();
        yqp.a("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote json:%s", localObject);
        parambpsf.a.putExtra("pl", localObject);
        parambpsf = new StringBuilder();
        localObject = localbpgd.jdField_a_of_type_ArrayOfJavaLangString;
        int i = localObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          parambpsf.append(localObject[paramInt]).append(";");
          paramInt += 1;
        }
        parambpsf.deleteCharAt(parambpsf.length() - 1);
        localObject = parambpsf.toString();
        if (localbpgd.jdField_a_of_type_Boolean) {}
        for (parambpsf = "1";; parambpsf = "2")
        {
          yqu.a("video_edit", "pub_vote", 1, 0, new String[] { localObject, parambpsf });
          yqu.a("video_edit_new", "qa_send", 1, 0, new String[0]);
          return;
        }
      }
      yqp.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, parse vote json error.");
      return;
    }
    yqp.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote layer is empty.");
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_Bpgd;
    int i;
    if (localObject != null)
    {
      i = 0;
      if (i >= ((bpgd)localObject).jdField_a_of_type_ArrayOfJavaLangString.length) {
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
        for (localObject = anni.a(2131702513);; localObject = anni.a(2131702592))
        {
          bglp.a(localContext, 230, (String)localObject, null, anni.a(2131702701), anni.a(2131702656), new bpgb(this, i), new bpgc(this)).show();
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
    this.jdField_a_of_type_Bpgd = null;
    yqp.b("Q.qqstory.publish.edit.EditVideoVote", "deleteVote.");
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bpep.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpga
 * JD-Core Version:    0.7.0.1
 */