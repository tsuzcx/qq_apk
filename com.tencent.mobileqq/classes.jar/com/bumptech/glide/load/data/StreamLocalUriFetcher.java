package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.support.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StreamLocalUriFetcher
  extends LocalUriFetcher<InputStream>
{
  private static final UriMatcher a = new UriMatcher(-1);
  
  static
  {
    a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
    a.addURI("com.android.contacts", "contacts/lookup/*", 1);
    a.addURI("com.android.contacts", "contacts/#/photo", 2);
    a.addURI("com.android.contacts", "contacts/#", 3);
    a.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    a.addURI("com.android.contacts", "phone_lookup/*", 5);
  }
  
  public StreamLocalUriFetcher(ContentResolver paramContentResolver, Uri paramUri)
  {
    super(paramContentResolver, paramUri);
  }
  
  private InputStream a(ContentResolver paramContentResolver, Uri paramUri)
  {
    return ContactsContract.Contacts.openContactPhotoInputStream(paramContentResolver, paramUri, true);
  }
  
  private InputStream c(Uri paramUri, ContentResolver paramContentResolver)
  {
    int i = a.match(paramUri);
    if (i != 1) {
      if (i != 3)
      {
        if (i != 5) {
          return paramContentResolver.openInputStream(paramUri);
        }
      }
      else {
        return a(paramContentResolver, paramUri);
      }
    }
    paramUri = ContactsContract.Contacts.lookupContact(paramContentResolver, paramUri);
    if (paramUri != null) {
      return a(paramContentResolver, paramUri);
    }
    throw new FileNotFoundException("Contact cannot be found");
  }
  
  protected InputStream a(Uri paramUri, ContentResolver paramContentResolver)
  {
    paramContentResolver = c(paramUri, paramContentResolver);
    if (paramContentResolver != null) {
      return paramContentResolver;
    }
    paramContentResolver = new StringBuilder();
    paramContentResolver.append("InputStream is null for ");
    paramContentResolver.append(paramUri);
    throw new FileNotFoundException(paramContentResolver.toString());
  }
  
  @NonNull
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  protected void a(InputStream paramInputStream)
  {
    paramInputStream.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.StreamLocalUriFetcher
 * JD-Core Version:    0.7.0.1
 */