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

public class bjyh
  extends bjwu
  implements DialogInterface.OnDismissListener, bjyl
{
  public static String a;
  private float jdField_a_of_type_Float;
  private bjyk jdField_a_of_type_Bjyk;
  private bkop jdField_a_of_type_Bkop;
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditVideoVote";
  }
  
  public bjyh(@NonNull bjww parambjww)
  {
    super(parambjww);
  }
  
  private JSONObject a(@NonNull bjyk parambjyk)
  {
    bkat localbkat = a().a();
    if (localbkat != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("v", 1);
        localJSONObject1.put("id", 1);
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(vzo.a(a())), Integer.valueOf(vzo.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkat.u * localbkat.q), Float.valueOf(localbkat.v * localbkat.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkat.b.x + localbkat.s), Float.valueOf(localbkat.b.y + localbkat.t) }));
        parambjyk = new JSONArray(Arrays.asList(parambjyk.jdField_a_of_type_ArrayOfJavaLangString));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", localJSONArray1);
        localJSONObject2.put("ls", localJSONArray2);
        localJSONObject2.put("lp", localJSONArray3);
        localJSONObject2.put("r", localbkat.r);
        localJSONObject2.put("c", parambjyk);
        localJSONObject1.put("a", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException parambjyk)
      {
        veg.e("Q.qqstory.publish.edit.EditVideoVote", parambjyk.toString());
      }
    }
    return null;
  }
  
  public static void a(Bundle paramBundle, bkat parambkat)
  {
    if (parambkat != null)
    {
      paramBundle.putFloat("scale", parambkat.q);
      paramBundle.putFloat("rotate", parambkat.r);
      paramBundle.putFloat("translateX", parambkat.s);
      paramBundle.putFloat("translateY", parambkat.t);
    }
  }
  
  private void a(bjyk parambjyk, int paramInt)
  {
    if (this.jdField_a_of_type_Bkop != null) {
      j();
    }
    this.jdField_a_of_type_Bkop = new bkop(a(), this, parambjyk, paramInt);
    this.jdField_a_of_type_Bkop.setContentView(2131561443);
    this.jdField_a_of_type_Bkop.setOnDismissListener(this);
    this.jdField_a_of_type_Bkop.show();
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bkop != null) && (this.jdField_a_of_type_Bkop.isShowing()))
    {
      this.jdField_a_of_type_Bkop.dismiss();
      this.jdField_a_of_type_Bkop = null;
    }
  }
  
  public bjyk a()
  {
    return this.jdField_a_of_type_Bjyk;
  }
  
  @NonNull
  public bkar a()
  {
    Object localObject = (bjsd)a(bjsd.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bjsd)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("VoteLayer is null.");
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    a(bjyl.class, this);
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
  
  public void a(bkat parambkat, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bjyk == null)
    {
      veg.e("Q.qqstory.publish.edit.EditVideoVote", "why vote info is null????");
      this.jdField_a_of_type_Bjww.a(35);
      return;
    }
    Object localObject = new bkhv().c(parambkat);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    ((Matrix)localObject).mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0];
    paramFloat2 = parambkat.u / 2.0F;
    float f1 = arrayOfFloat[1];
    float f2 = parambkat.v / 2.0F;
    localObject = new Bundle();
    a((Bundle)localObject, parambkat);
    ((Bundle)localObject).putInt("element_index", vyt.a(this.jdField_a_of_type_Bjyk.jdField_a_of_type_ArrayOfAndroidGraphicsRect, (int)(paramFloat1 + paramFloat2), (int)(f1 + f2)));
    this.jdField_a_of_type_Bjww.a(35, localObject);
    parambkat.l = false;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      bkat localbkat = a().a();
      if (localbkat != null) {}
      try
      {
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(vzo.a(a())), Integer.valueOf(vzo.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkat.u * localbkat.q), Float.valueOf(localbkat.v * localbkat.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkat.b.x + localbkat.s), Float.valueOf(localbkat.b.y + localbkat.t) }));
        JSONArray localJSONArray4 = new JSONArray(Arrays.asList(this.jdField_a_of_type_Bjyk.jdField_a_of_type_ArrayOfJavaLangString));
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localbkat.jdField_a_of_type_ArrayOfAndroidGraphicsRect != null)
        {
          localObject1 = localObject2;
          if (localbkat.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length > 0)
          {
            localObject2 = new JSONArray();
            Rect[] arrayOfRect = localbkat.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
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
        ((JSONObject)localObject2).put("r", localbkat.r);
        ((JSONObject)localObject2).put("c", localJSONArray4);
        if (localObject1 != null) {
          ((JSONObject)localObject2).put("tr", localObject1);
        }
        paramJSONObject.put(jdField_a_of_type_JavaLangString, localObject2);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        veg.e("Q.qqstory.publish.edit.EditVideoVote", paramJSONObject.toString());
        return;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjye == null)
    {
      veg.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bjyk = new bjyk(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjye == null)
    {
      veg.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bjyk = new bjyk(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bkop != null) && (this.jdField_a_of_type_Bkop.isShowing()))
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
    a(this.jdField_a_of_type_Bjyk, paramInt);
    a().e();
    vel.a("video_edit", "clk_vote_entry", 1, 0, new String[0]);
  }
  
  public void b(int paramInt, bkkm parambkkm)
  {
    bjyk localbjyk = this.jdField_a_of_type_Bjyk;
    if (localbjyk != null)
    {
      ((bjbt)bjae.a(15)).a(null);
      Object localObject = a(localbjyk);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).toString();
        veg.a("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote json:%s", localObject);
        parambkkm.a.putExtra("pl", localObject);
        parambkkm = new StringBuilder();
        localObject = localbjyk.jdField_a_of_type_ArrayOfJavaLangString;
        int i = localObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          parambkkm.append(localObject[paramInt]).append(";");
          paramInt += 1;
        }
        parambkkm.deleteCharAt(parambkkm.length() - 1);
        localObject = parambkkm.toString();
        if (localbjyk.jdField_a_of_type_Boolean) {}
        for (parambkkm = "1";; parambkkm = "2")
        {
          vel.a("video_edit", "pub_vote", 1, 0, new String[] { localObject, parambkkm });
          vel.a("video_edit_new", "qa_send", 1, 0, new String[0]);
          return;
        }
      }
      veg.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, parse vote json error.");
      return;
    }
    veg.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote layer is empty.");
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_Bjyk;
    int i;
    if (localObject != null)
    {
      i = 0;
      if (i >= ((bjyk)localObject).jdField_a_of_type_ArrayOfJavaLangString.length) {
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
        for (localObject = ajyc.a(2131703721);; localObject = ajyc.a(2131703800))
        {
          bbcv.a(localContext, 230, (String)localObject, null, ajyc.a(2131703909), ajyc.a(2131703864), new bjyi(this, i), new bjyj(this)).show();
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
    this.jdField_a_of_type_Bjyk = null;
    veg.b("Q.qqstory.publish.edit.EditVideoVote", "deleteVote.");
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bjww.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyh
 * JD-Core Version:    0.7.0.1
 */