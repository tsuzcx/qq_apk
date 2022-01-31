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

public class bjyy
  extends bjxl
  implements DialogInterface.OnDismissListener, bjzc
{
  public static String a;
  private float jdField_a_of_type_Float;
  private bjzb jdField_a_of_type_Bjzb;
  private bkpg jdField_a_of_type_Bkpg;
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditVideoVote";
  }
  
  public bjyy(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
  }
  
  private JSONObject a(@NonNull bjzb parambjzb)
  {
    bkbk localbkbk = a().a();
    if (localbkbk != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("v", 1);
        localJSONObject1.put("id", 1);
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(vzl.a(a())), Integer.valueOf(vzl.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkbk.u * localbkbk.q), Float.valueOf(localbkbk.v * localbkbk.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkbk.b.x + localbkbk.s), Float.valueOf(localbkbk.b.y + localbkbk.t) }));
        parambjzb = new JSONArray(Arrays.asList(parambjzb.jdField_a_of_type_ArrayOfJavaLangString));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", localJSONArray1);
        localJSONObject2.put("ls", localJSONArray2);
        localJSONObject2.put("lp", localJSONArray3);
        localJSONObject2.put("r", localbkbk.r);
        localJSONObject2.put("c", parambjzb);
        localJSONObject1.put("a", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException parambjzb)
      {
        ved.e("Q.qqstory.publish.edit.EditVideoVote", parambjzb.toString());
      }
    }
    return null;
  }
  
  public static void a(Bundle paramBundle, bkbk parambkbk)
  {
    if (parambkbk != null)
    {
      paramBundle.putFloat("scale", parambkbk.q);
      paramBundle.putFloat("rotate", parambkbk.r);
      paramBundle.putFloat("translateX", parambkbk.s);
      paramBundle.putFloat("translateY", parambkbk.t);
    }
  }
  
  private void a(bjzb parambjzb, int paramInt)
  {
    if (this.jdField_a_of_type_Bkpg != null) {
      j();
    }
    this.jdField_a_of_type_Bkpg = new bkpg(a(), this, parambjzb, paramInt);
    this.jdField_a_of_type_Bkpg.setContentView(2131561442);
    this.jdField_a_of_type_Bkpg.setOnDismissListener(this);
    this.jdField_a_of_type_Bkpg.show();
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bkpg != null) && (this.jdField_a_of_type_Bkpg.isShowing()))
    {
      this.jdField_a_of_type_Bkpg.dismiss();
      this.jdField_a_of_type_Bkpg = null;
    }
  }
  
  public bjzb a()
  {
    return this.jdField_a_of_type_Bjzb;
  }
  
  @NonNull
  public bkbi a()
  {
    Object localObject = (bjsu)a(bjsu.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bjsu)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("VoteLayer is null.");
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    a(bjzc.class, this);
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
  
  public void a(bkbk parambkbk, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bjzb == null)
    {
      ved.e("Q.qqstory.publish.edit.EditVideoVote", "why vote info is null????");
      this.jdField_a_of_type_Bjxn.a(35);
      return;
    }
    Object localObject = new bkim().c(parambkbk);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    ((Matrix)localObject).mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0];
    paramFloat2 = parambkbk.u / 2.0F;
    float f1 = arrayOfFloat[1];
    float f2 = parambkbk.v / 2.0F;
    localObject = new Bundle();
    a((Bundle)localObject, parambkbk);
    ((Bundle)localObject).putInt("element_index", vyq.a(this.jdField_a_of_type_Bjzb.jdField_a_of_type_ArrayOfAndroidGraphicsRect, (int)(paramFloat1 + paramFloat2), (int)(f1 + f2)));
    this.jdField_a_of_type_Bjxn.a(35, localObject);
    parambkbk.l = false;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      bkbk localbkbk = a().a();
      if (localbkbk != null) {}
      try
      {
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(vzl.a(a())), Integer.valueOf(vzl.d(a())) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkbk.u * localbkbk.q), Float.valueOf(localbkbk.v * localbkbk.q) }));
        JSONArray localJSONArray3 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkbk.b.x + localbkbk.s), Float.valueOf(localbkbk.b.y + localbkbk.t) }));
        JSONArray localJSONArray4 = new JSONArray(Arrays.asList(this.jdField_a_of_type_Bjzb.jdField_a_of_type_ArrayOfJavaLangString));
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localbkbk.jdField_a_of_type_ArrayOfAndroidGraphicsRect != null)
        {
          localObject1 = localObject2;
          if (localbkbk.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length > 0)
          {
            localObject2 = new JSONArray();
            Rect[] arrayOfRect = localbkbk.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
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
        ((JSONObject)localObject2).put("r", localbkbk.r);
        ((JSONObject)localObject2).put("c", localJSONArray4);
        if (localObject1 != null) {
          ((JSONObject)localObject2).put("tr", localObject1);
        }
        paramJSONObject.put(jdField_a_of_type_JavaLangString, localObject2);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        ved.e("Q.qqstory.publish.edit.EditVideoVote", paramJSONObject.toString());
        return;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjyv == null)
    {
      ved.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bjzb = new bjzb(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjyv == null)
    {
      ved.e("Q.qqstory.publish.edit.EditVideoVote", "set vote info but mUi is null.");
      return;
    }
    this.jdField_a_of_type_Bjzb = new bjzb(paramArrayOfString, paramBitmap, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bkpg != null) && (this.jdField_a_of_type_Bkpg.isShowing()))
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
    a(this.jdField_a_of_type_Bjzb, paramInt);
    a().e();
    vei.a("video_edit", "clk_vote_entry", 1, 0, new String[0]);
  }
  
  public void b(int paramInt, bkld parambkld)
  {
    bjzb localbjzb = this.jdField_a_of_type_Bjzb;
    if (localbjzb != null)
    {
      ((bjck)bjav.a(15)).a(null);
      Object localObject = a(localbjzb);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).toString();
        ved.a("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote json:%s", localObject);
        parambkld.a.putExtra("pl", localObject);
        parambkld = new StringBuilder();
        localObject = localbjzb.jdField_a_of_type_ArrayOfJavaLangString;
        int i = localObject.length;
        paramInt = 0;
        while (paramInt < i)
        {
          parambkld.append(localObject[paramInt]).append(";");
          paramInt += 1;
        }
        parambkld.deleteCharAt(parambkld.length() - 1);
        localObject = parambkld.toString();
        if (localbjzb.jdField_a_of_type_Boolean) {}
        for (parambkld = "1";; parambkld = "2")
        {
          vei.a("video_edit", "pub_vote", 1, 0, new String[] { localObject, parambkld });
          vei.a("video_edit_new", "qa_send", 1, 0, new String[0]);
          return;
        }
      }
      ved.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, parse vote json error.");
      return;
    }
    ved.b("Q.qqstory.publish.edit.EditVideoVote", "editVideoPrePublish, vote layer is empty.");
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_Bjzb;
    int i;
    if (localObject != null)
    {
      i = 0;
      if (i >= ((bjzb)localObject).jdField_a_of_type_ArrayOfJavaLangString.length) {
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
        for (localObject = ajya.a(2131703732);; localObject = ajya.a(2131703811))
        {
          bbdj.a(localContext, 230, (String)localObject, null, ajya.a(2131703920), ajya.a(2131703875), new bjyz(this, i), new bjza(this)).show();
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
    this.jdField_a_of_type_Bjzb = null;
    ved.b("Q.qqstory.publish.edit.EditVideoVote", "deleteVote.");
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bjxn.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyy
 * JD-Core Version:    0.7.0.1
 */