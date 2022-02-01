import com.tencent.qphone.base.util.QLog;

class anep
  implements anfg
{
  anep(anen paramanen) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsPresenter", 2, "res download sucess roleId=" + paramInt1 + "dressIds=" + paramArrayOfInt);
      }
      if (anen.a(this.a) != null) {
        anen.a(this.a).e();
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anep
 * JD-Core Version:    0.7.0.1
 */