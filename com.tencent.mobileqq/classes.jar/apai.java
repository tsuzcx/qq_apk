import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.RawContacts;

class apai
{
  public static final String[] a = { "_id", "sourceid", "contact_id" };
  public static final String[] b = { "sync1", "sync2", "sync3" };
  
  public static final Uri a(String paramString)
  {
    return ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", paramString).appendQueryParameter("account_type", "com.tencent.mobileqq.account").appendQueryParameter("caller_is_syncadapter", apac.b()).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apai
 * JD-Core Version:    0.7.0.1
 */