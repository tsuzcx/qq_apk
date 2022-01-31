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

public class bihm
  extends bifz
  implements DialogInterface.OnDismissListener, bihq
{
  public static String a;
  private float jdField_a_of_type_Float;
  private bihp jdField_a_of_type_Bihp;
  private biyd jdField_a_of_type_Biyd;
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditVideoVote";
  }
  
  public bihm(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  private JSONObject a(@NonNull bihp parambihp)
  {
    bijy localbijy = a().a();
    if (localbijy != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("v", 1);
        localJSONObject1.put("id", 1);
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(vms.a(a())), Integer.valueOf(vms.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbijy.u * localbijy.q), Float.valueOf(localbijy.v * localbijy.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbijy.b.x + localbijy.s), Float.valueOf(localbijy.b.y + localbijy.t) }));
        parambihp = new JSONArray(Arrays.asList(parambihp.jdField_a_of_type_ArrayOfJavaLangString));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", localJSONArray1);
        localJSONObject2.put("ls", localJSONArray2);
        localJSONObject2.put("lp", localJSONArray3);
        localJSONObject2.put("r", localbijy.r);
        localJSONObject2.put("c", parambihp);
        localJSONObject1.put("a", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException parambihp)
      {
        urk.e("Q.qqstory.publish.edit.EditVideoVote", parambihp.toString());
      }
    }
    return null;
  }
  
  public static void a(Bundle paramBundle, bijy parambijy)
  {
    if (parambijy != null)
    {
      paramBundle.putFloat("scale", parambijy.q);
      paramBundle.putFloat("rotate", parambijy.r);
      paramBundle.putFloat("translateX", parambijy.s);
      paramBundle.putFloat("translateY", parambijy.t);
    }
  }
  
  private void a(bihp parambihp, int paramInt)
  {
    if (this.jdField_a_of_type_Biyd != null) {
      j();
    }
    this.jdField_a_of_type_Biyd = new biyd(a(), this, parambihp, paramInt);
    this.jdField_a_of_type_Biyd.setContentView(2131495852);
    this.jdField_a_of_type_Biyd.setOnDismissListener(this);
    this.jdField_a_of_type_Biyd.show();
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Biyd != null) && (this.jdField_a_of_type_Biyd.isShowing()))
    {
      this.jdField_a_of_type_Biyd.dismiss();
      this.jdField_a_of_type_Biyd = null;
    }
  }
  
  public bihp a()
  {
    return this.jdField_a_of_type_Bihp;
  }
  
  @NonNull
  public bijw a()
  {
    Object localObject = (bibg)a(bibg.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bibg)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("VoteLayer is null.");
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    a(bihq.class, this);
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
  
  public void a(bijy parambijy, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bihp == null)
    {
      urk.e("Q.qqstory.publish.edit.EditVideoVote", "why vote info is null????");
      this.jdField_a_of_type_Bigb.a(35);
      return;
    }
    Object localObject = new bira().c(parambijy);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    ((Matrix)localObject).mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0];
    paramFloat2 = parambijy.u / 2.0F;
    float f1 = arrayOfFloat[1];
    float f2 = parambijy.v / 2.0F;
    localObject = new Bundle();
    a((Bundle)localObject, parambijy);
    ((Bundle)localObject).putInt("element_index", vlx.a(this.jdField_a_of_type_Bihp.jdField_a_of_type_ArrayOfAndroidGraphicsRect, (int)(paramFloat1 + paramFloat2), (int)(f1 + f2)));
    this.jdField_a_of_type_Bigb.a(35, localObject);
    parambijy.l = false;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      bijy localbijy = a().a();
      if (localbijy != null) {}
      try
      {
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(vms.a(a())), Integer.valueOf(vms.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbijy.u * localbijy.q), Float.valueOf(localbijy.v * localbijy.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbijy.b.x + localbijy.s), Float.valueOf(localbijy.b.y + localbijy.t) }));
        JSONArray localJSONArray4 = new JSONArray(Arrays.asList(this.jdField_a_of_type_Bihp.jdField_a_of_type_ArrayOfJavaLangString));
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localbijy.jdField_a_of_type_ArrayOfAndroidGraphicsRect != null)
        {
          localObject1 = localObject2;
          if (localbijy.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length > 0)
          {
            localObject2 = new JSONArray();
            Rect[] arrayOfRect = localbijy.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
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
        ((JSONObject)localObject2).put("r", localbijy.r);
        ((JSONObject)localObject2).put("c", localJSONArray4);
        if (localObject1 != null) {
          ((JSONObject)localObject2).put("tr", localObject1);
        }
        paramJSONObject.put(jdField_a_of_type_JavaLangString, localObject2);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        urk.e("Q.qqstory.publish.edit.EditVideoVote", paramJSONObject.toString());
        return;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bihj == null)
    {
      urk.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bihp = new bihp(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bihj == null)
    {
      urk.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bihp = new bihp(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Biyd != null) && (this.jdField_a_of_type_Biyd.isShowing()))
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
    a(this.jdField_a_of_type_Bihp, paramInt);
    a().e();
    urp.a("video_edit", "clk_vote_entry", 1, 0, new String[0]);
  }
  
  public void b(int paramInt, bitz parambitz)
  {
    bihp localbihp = this.jdField_a_of_type_Bihp;
    if (localbihp != null)
    {
      ((bhhb)bhfm.a(15)).a(null);
      Object localObject = a(localbihp);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).toString();
        urk.a("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote json:%s", localObject);
        parambitz.a.putExtra("pl", localObject);
        parambitz = new StringBuilder();
        localObject = localbihp.jdField_a_of_type_ArrayOfJavaLangString;
        int i = localObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          parambitz.append(localObject[paramInt]).append(";");
          paramInt += 1;
        }
        parambitz.deleteCharAt(parambitz.length() - 1);
        localObject = parambitz.toString();
        if (localbihp.jdField_a_of_type_Boolean) {}
        for (parambitz = "1";; parambitz = "2")
        {
          urp.a("video_edit", "pub_vote", 1, 0, new String[] { localObject, parambitz });
          urp.a("video_edit_new", "qa_send", 1, 0, new String[0]);
          return;
        }
      }
      urk.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, parse vote json error.");
      return;
    }
    urk.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote layer is empty.");
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_Bihp;
    int i;
    if (localObject != null)
    {
      i = 0;
      if (i >= ((bihp)localObject).jdField_a_of_type_ArrayOfJavaLangString.length) {
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
        for (localObject = ajjy.a(2131637936);; localObject = ajjy.a(2131638015))
        {
          babr.a(localContext, 230, (String)localObject, null, ajjy.a(2131638124), ajjy.a(2131638079), new bihn(this, i), new biho(this)).show();
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
    this.jdField_a_of_type_Bihp = null;
    urk.b("Q.qqstory.publish.edit.EditVideoVote", "deleteVote.");
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bigb.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihm
 * JD-Core Version:    0.7.0.1
 */