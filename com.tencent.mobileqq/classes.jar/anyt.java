import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class anyt
  implements anyn
{
  private String a = "ReadInJoyLauncher";
  
  public void a(Context paramContext, ColorNote paramColorNote)
  {
    paramColorNote = paramColorNote.getReserve();
    if (paramColorNote == null) {
      return;
    }
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramColorNote, 0, paramColorNote.length);
      localParcel.setDataPosition(0);
      paramColorNote = new ArticleInfo(localParcel);
      if (paramColorNote == null)
      {
        QLog.d(this.a, 2, "init color error something is null");
        return;
      }
    }
    catch (Exception paramColorNote)
    {
      for (;;)
      {
        QLog.e(this.a, 2, "unmarshall error");
        paramColorNote.printStackTrace();
        paramColorNote = null;
      }
      QLog.d(this.a, 2, "articleInfo From ColorNote :\n" + paramColorNote.toString());
      paramColorNote = osb.b(paramContext, paramColorNote);
      paramColorNote.addFlags(268435456);
      paramColorNote.putExtra("from_color_note", true);
      paramContext.startActivity(paramColorNote);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyt
 * JD-Core Version:    0.7.0.1
 */