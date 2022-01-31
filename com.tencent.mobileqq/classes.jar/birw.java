import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobSegment;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class birw
  extends bifz
  implements DialogInterface.OnDismissListener, bibk
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private birz jdField_a_of_type_Birz;
  @Nullable
  private bisc jdField_a_of_type_Bisc;
  private float b;
  private float c;
  private float d;
  
  public birw(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  private String a(bisc parambisc)
  {
    int i = -1;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      bijj localbijj = (bijj)a().a();
      if (localbijj == null) {
        break label304;
      }
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        parambisc = new JSONArray(Arrays.asList(parambisc.jdField_a_of_type_ArrayOfJavaLangString));
        localJSONObject1.put("t", i);
        localJSONObject1.put("c", parambisc);
        parambisc = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(vms.a(a())), Integer.valueOf(vms.d(a())) }));
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbijj.u * localbijj.q), Float.valueOf(localbijj.v * localbijj.q) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbijj.b.x + localbijj.s), Float.valueOf(localbijj.b.y + localbijj.t) }));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", parambisc);
        localJSONObject2.put("ls", localJSONArray1);
        localJSONObject2.put("lp", localJSONArray2);
        localJSONObject2.put("r", localbijj.r);
        localJSONObject1.put("a", localJSONObject2);
        parambisc = localJSONObject1.toString();
        return parambisc;
      }
      catch (JSONException parambisc)
      {
        urk.e("Q.qqstory.publish.editEditVideoInteract", parambisc.toString());
      }
      i = 1;
    }
    label304:
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Birz != null) && (this.jdField_a_of_type_Birz.isShowing())) {
      d();
    }
    this.jdField_a_of_type_Birz = new birz(a(), this, paramInt);
    this.jdField_a_of_type_Birz.a(a());
    this.jdField_a_of_type_Birz.setContentView(2131495852);
    this.jdField_a_of_type_Birz.setOnDismissListener(this);
    this.jdField_a_of_type_Birz.show();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Birz != null) && (this.jdField_a_of_type_Birz.isShowing()))
    {
      this.jdField_a_of_type_Birz.dismiss();
      this.jdField_a_of_type_Birz = null;
    }
  }
  
  public Bitmap a()
  {
    biji localbiji = a();
    if (localbiji.a()) {}
    for (;;)
    {
      return null;
      int i = localbiji.a.width();
      int j = localbiji.a.height();
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          localbiji.d(new Canvas(localBitmap));
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        urk.c("Q.qqstory.publish.editEditVideoInteract", "OutOfMemoryError :", localOutOfMemoryError);
      }
    }
    return null;
  }
  
  @NonNull
  public biji a()
  {
    Object localObject = (bibg)a(bibg.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bibg)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("InteractPasterLayer is null.");
    }
    return localObject;
  }
  
  public bisc a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bisc;
  }
  
  public JobSegment<bitz, bitz> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Bigb.a.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bigb.a.a instanceof EditLocalVideoSource))) {
      return new bium(this);
    }
    return new biud(this);
  }
  
  public void a()
  {
    super.a();
    a(bibk.class, this);
  }
  
  public void a(int paramInt, bisc parambisc)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = parambisc.jdField_a_of_type_AndroidGraphicsBitmap;
      a().a(localBitmap, parambisc.jdField_a_of_type_ArrayOfAndroidGraphicsRect, parambisc.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
      return;
      this.jdField_a_of_type_Bisc = parambisc;
    }
  }
  
  public void a(Bundle paramBundle, bisc parambisc)
  {
    int i = paramBundle.getInt("interact_type");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale");
    this.b = paramBundle.getFloat("rotate");
    this.c = paramBundle.getFloat("translateX");
    this.d = paramBundle.getFloat("translateY");
    a(i, parambisc);
  }
  
  public void a(bijj parambijj, float paramFloat1, float paramFloat2)
  {
    Bundle localBundle = new Bundle();
    bihm.a(localBundle, parambijj);
    localBundle.putInt("interact_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bigb.a(38, localBundle);
    parambijj.l = false;
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 1001;
    this.jdField_a_of_type_Bisc = new bisc(paramBitmap, paramArrayOfString, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Birz != null) && (this.jdField_a_of_type_Birz.isShowing()))
    {
      d();
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, bitz parambitz)
  {
    bisc localbisc = a();
    if (localbisc != null)
    {
      ((bhhb)bhfm.a(15)).a(null);
      String str = a(localbisc);
      if (!TextUtils.isEmpty(str))
      {
        urk.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, interact json:%s", str);
        parambitz.a.putExtra("i_l", str);
        urp.a("video_edit", "pub_vote", 2, 0, new String[] { localbisc.jdField_a_of_type_ArrayOfJavaLangString[0] });
        urp.a("video_edit_new", "qa_send", 2, 0, new String[0]);
      }
      return;
    }
    urk.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, paster info is null. type:%s", Integer.valueOf(this.jdField_a_of_type_Int));
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      d();
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
        this.jdField_a_of_type_Float = paramObject.getFloat("scale");
        this.b = paramObject.getFloat("rotate");
        this.c = paramObject.getFloat("translateX");
        this.d = paramObject.getFloat("translateY");
        paramInt = paramObject.getInt("interact_type");
      }
    }
    if (paramInt != 1001) {
      throw new IllegalArgumentException("unSupport paster type:" + paramInt);
    }
    a(paramInt);
    a().e();
    urp.a("video_edit", "clk_vote_entry", 2, 0, new String[0]);
  }
  
  public void b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      urk.d("Q.qqstory.publish.editEditVideoInteract", "delete interact paster error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      this.jdField_a_of_type_Bisc = null;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == -1) {
      return true;
    }
    bisc localbisc = a();
    if (localbisc == null) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localbisc.jdField_a_of_type_ArrayOfJavaLangString.length) || (TextUtils.isEmpty(localbisc.jdField_a_of_type_ArrayOfJavaLangString[i])))
      {
        if (i != localbisc.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        return true;
      }
      i += 1;
    }
    babr.a(a(), 230, ajjy.a(2131638002), null, ajjy.a(2131638066), ajjy.a(2131638022), new birx(this), new biry(this)).show();
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bigb.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birw
 * JD-Core Version:    0.7.0.1
 */